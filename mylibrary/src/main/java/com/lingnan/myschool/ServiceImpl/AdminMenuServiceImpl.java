package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.AdminMenuService;
import com.lingnan.myschool.Service.AdminRoleMenuService;
import com.lingnan.myschool.Service.AdminUserRoleService;
import com.lingnan.myschool.Service.UserService;
import com.lingnan.myschool.mapper.AdminMenuMapper;
import com.lingnan.myschool.pojo.AdminMenu;
import com.lingnan.myschool.pojo.AdminRoleMenu;
import com.lingnan.myschool.pojo.AdminUserRole;
import com.lingnan.myschool.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuServiceImpl implements AdminMenuService{
    @Autowired
    AdminMenuMapper adminMenuMapper;

    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    UserService userService;
    public List<AdminMenu> getMenusByCurrentUser(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);

        List<Integer> rids = adminUserRoleService.findAdminUserRoleByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        List<Integer> mids = adminRoleMenuService.findAdminRoleMenuByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());

        List<AdminMenu> menus = adminMenuMapper.findAdminMenuById(mids).stream().distinct().collect(Collectors.toList());
        handleMenus(menus);
        return menus;

    }

    public List<AdminMenu> getAllByParentId(Integer pid){
            return adminMenuMapper.getAllByParentId(pid);
    }

    public void handleMenus(List<AdminMenu> menus){
        menus.forEach(
                m -> {
                    List<AdminMenu> children = getAllByParentId(m.getId());
                    m.setChildren(children);
                }
        );

        menus.removeIf(m -> m.getParent_id()!=0);
    }



}
