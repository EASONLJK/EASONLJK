package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRolePermissionMapper {
    public List<AdminRolePermission> findAllByRid(@Param("rid") List<Integer> rid);
}
