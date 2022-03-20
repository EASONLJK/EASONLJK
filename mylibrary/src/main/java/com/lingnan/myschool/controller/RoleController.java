package com.lingnan.myschool.controller;


import com.lingnan.myschool.Service.AdminRoleMenuService;
import com.lingnan.myschool.Service.AdminRoleService;
import com.lingnan.myschool.result.Result;
import com.lingnan.myschool.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class RoleController {

    @Autowired
    AdminRoleService adminRoleService;

    @GetMapping("/admin/role")
    public Result listRole(){
        return ResultFactory.buildSuccessResult(adminRoleService.listRoleAndWithPermsAndMenus());
    }

}
