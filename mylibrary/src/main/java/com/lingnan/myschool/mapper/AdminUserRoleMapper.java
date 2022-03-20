package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserRoleMapper {
    public List<AdminUserRole> findAdminUserRoleByUid(@Param("uid") Integer uid);
    void saveAdminUseridAndRoleid(AdminUserRole adminUserRole);
    void deleteAllByUid(@Param("uid") Integer uid);
}
