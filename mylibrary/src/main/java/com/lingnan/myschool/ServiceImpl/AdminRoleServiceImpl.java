package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminPermissionService;
import com.lingnan.myschool.Service.AdminRoleMenuService;
import com.lingnan.myschool.Service.AdminRolePermissionService;
import com.lingnan.myschool.Service.AdminRoleService;
import com.lingnan.myschool.mapper.AdminRoleMapper;
import com.lingnan.myschool.mapper.AdminUserRoleMapper;
import com.lingnan.myschool.mapper.UserMapper;
import com.lingnan.myschool.pojo.AdminRole;
import com.lingnan.myschool.pojo.AdminUserRole;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    AdminRoleMapper adminRoleMapper;

    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Autowired
    AdminMenuServiceImpl adminMenuService;

    @Autowired
    UserMapper userMapper;

    public List<AdminRole> findAllByName(String name){
        return adminRoleMapper.findAllByName(name);
    }

    @Override
    public List<AdminRole> listRoleByName(String name) {
        Integer uid = userMapper.findByName(name).getId();

        List<Integer> rids = adminUserRoleMapper.findAdminUserRoleByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(rids)){
            List<AdminRole> roleByrid1 = adminRoleMapper.findRoleByrid(rids);
            return roleByrid1;
        }else
        {
            List<AdminRole> roleByrid = new ArrayList<AdminRole>();
            AdminRole adminRole = new AdminRole();
            adminRole.setId(0);
            roleByrid.add(adminRole);
            return roleByrid;
        }

    }

    @Override
    public List<AdminRole> listRoleAndWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleMapper.findAllRole();
//        for (AdminRole role : roles) {
//            adminMenuService.getAllByParentId()
//        }
        return roles;
    }
}
