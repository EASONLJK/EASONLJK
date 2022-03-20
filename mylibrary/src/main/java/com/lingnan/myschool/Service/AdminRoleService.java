package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleService {
    public List<AdminRole> findAllByName(String name);
    public List<AdminRole> listRoleByName(String name);
    public List<AdminRole> listRoleAndWithPermsAndMenus();
}
