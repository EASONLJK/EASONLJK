package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminRoleMenuService;
import com.lingnan.myschool.mapper.AdminRoleMenuMapper;
import com.lingnan.myschool.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<AdminRoleMenu> findAdminRoleMenuByRid(List<Integer> rid) {
        return adminRoleMenuMapper.findAdminRoleMenuByRid(rid);
    }
}
