package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.*;
import com.lingnan.myschool.mapper.AdminPermissionMapper;
import com.lingnan.myschool.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {

    @Autowired
    AdminPermissionMapper adminPermissionMapper;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    UserService userService;
    
    @Autowired
    AdminUserRoleService adminUserRoleService;

    public List<AdminPermission> findAllByPid(List<Integer> pid){
        return adminPermissionMapper.findAllByPid(pid);
    }

    public Set<String> listPermissionURLsByUser(String username){
        User user = userService.findByName(username);
        List<Integer> rids = adminUserRoleService.findAdminUserRoleByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
//        List<Integer> rids = adminRoleService.findAllByName(username)
//                .stream().map(AdminRole::getId).collect(Collectors.toList());
        List<Integer> pids = adminRolePermissionService.findAllByRid(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        Set<String> URLs = adminPermissionMapper.findAllByPid(pids)
                .stream().map(AdminPermission::getUrl).collect(Collectors.toSet());
        return URLs;
    }

    public boolean needFilter(String requestAPI){
        List<AdminPermission> perAll = adminPermissionMapper.findAll();
        for(AdminPermission p: perAll){
            if(p.getUrl().equals(requestAPI))
                return true;
        }
        return false;
    }
}
