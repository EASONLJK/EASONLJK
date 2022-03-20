package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMenuMapper {
    public List<AdminMenu> findAdminMenuById(@Param("mid") List<Integer> mid);
    public List<AdminMenu> getAllByParentId(@Param("pid") Integer pid);
}
