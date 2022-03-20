package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRolePermissionService {
    public List<AdminRolePermission> findAllByRid(List<Integer> rid);
}
