package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminRolePermissionService;
import com.lingnan.myschool.mapper.AdminRolePermissionMapper;
import com.lingnan.myschool.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService {

    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    @Override
    public List<AdminRolePermission> findAllByRid(List<Integer> rid) {
        return adminRolePermissionMapper.findAllByRid(rid);
    }
}
