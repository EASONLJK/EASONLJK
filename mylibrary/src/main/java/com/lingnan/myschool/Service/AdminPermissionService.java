package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.AdminPermission;

import java.util.List;
import java.util.Set;

public interface AdminPermissionService {
    public List<AdminPermission> findAllByPid(List<Integer> pid);
    public Set<String> listPermissionURLsByUser(String username);
    public boolean needFilter(String requestAPI);

}
