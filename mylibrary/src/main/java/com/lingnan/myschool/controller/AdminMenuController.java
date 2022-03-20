package com.lingnan.myschool.controller;


import com.lingnan.myschool.Service.AdminMenuService;
import com.lingnan.myschool.Service.AdminPermissionService;
import com.lingnan.myschool.Service.AdminRoleMenuService;
import com.lingnan.myschool.Service.UserService;
import com.lingnan.myschool.pojo.AdminMenu;
import com.lingnan.myschool.pojo.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class AdminMenuController {
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    UserService userService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @GetMapping("/admin/menu")
    public List<AdminMenu> menu(){
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/admin/per")
    public Set<String> test(@RequestParam String name){
        return adminPermissionService.listPermissionURLsByUser(name);
    }
//    @RequiresPermissions("/api/admin/user")  ???

}
