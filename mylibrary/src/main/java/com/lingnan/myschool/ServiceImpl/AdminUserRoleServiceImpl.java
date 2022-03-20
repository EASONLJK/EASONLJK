package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminUserRoleService;
import com.lingnan.myschool.mapper.AdminUserRoleMapper;
import com.lingnan.myschool.pojo.AdminUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {
    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    public List<AdminUserRole> findAdminUserRoleByUid(Integer uid){
       return adminUserRoleMapper.findAdminUserRoleByUid(uid);
    }

    @Override
    public void saveAdminUseridAndRoleid(AdminUserRole adminUserRole) {
        adminUserRoleMapper.saveAdminUseridAndRoleid(adminUserRole);
    }

    @Override
    public void deleteAllByUid(Integer uid) {
        adminUserRoleMapper.deleteAllByUid(uid);
    }
}
