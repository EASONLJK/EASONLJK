package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserRoleService {

    public List<AdminUserRole> findAdminUserRoleByUid(Integer uid);
    void saveAdminUseridAndRoleid(AdminUserRole adminUserRole);
    void deleteAllByUid(Integer uid);
}
