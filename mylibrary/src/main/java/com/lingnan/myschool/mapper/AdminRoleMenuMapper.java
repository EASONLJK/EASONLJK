package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRoleMenuMapper {
    public List<AdminRoleMenu> findAdminRoleMenuByRid(@Param("rid") List<Integer> id);
}
