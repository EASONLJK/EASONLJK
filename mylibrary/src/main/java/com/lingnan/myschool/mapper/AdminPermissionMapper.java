package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminPermissionMapper {
    public List<AdminPermission> findAllByPid(@Param("pid") List<Integer> pid);
    @Select("select * from admin_permission")
    public List<AdminPermission> findAll();
}
