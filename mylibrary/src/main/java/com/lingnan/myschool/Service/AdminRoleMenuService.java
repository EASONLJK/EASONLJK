package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleMenuService {
    public List<AdminRoleMenu> findAdminRoleMenuByRid(List<Integer> id);
}
