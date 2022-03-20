package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminRoleMapper {
    public List<AdminRole> findAllByName(@Param("name") String name);
    public List<AdminRole> findRoleByrid(@Param("rid") List<Integer> rid);
    @Select("select * from admin_role")
    public List<AdminRole> findAllRole();
}
