package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMenuService {
    public List<AdminMenu> getMenusByCurrentUser();
    public List<AdminMenu> getAllByParentId(Integer pid);
}
