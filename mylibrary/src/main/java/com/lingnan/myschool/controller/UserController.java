package com.lingnan.myschool.controller;

import com.lingnan.myschool.Service.AdminUserRoleService;
import com.lingnan.myschool.Service.UserService;
import com.lingnan.myschool.ServiceImpl.UserServiceImpl;
import com.lingnan.myschool.pojo.AdminRole;
import com.lingnan.myschool.pojo.AdminUserRole;
import com.lingnan.myschool.pojo.User;
import com.lingnan.myschool.result.Result;

import com.lingnan.myschool.result.ResultFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
//@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

//    @PostMapping (value ="/user/login")
//    public Map<String,Object> login(@RequestBody User user, HttpSession session){
//        System.out.println("前端传来的user"+user);
//        User user1 = userService.getUserByNameAndPassword(user);
//        Map<String,Object> rs = new HashMap<>();
//        if(user1!=null){
//            rs.put("code",200);
//            rs.put("msg","登录成功");
//            session.setAttribute("loginUser",user1);
//        }else {
//            rs.put("code",400);
//            rs.put("msg","登录失败");
//        }
//
//        return rs;
//    }

    @RequestMapping("/user/login")
    public Result login(@RequestBody User user){
        System.out.println(user);
        String name = user.getName();
        String password = user.getPassword();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name,password);
        usernamePasswordToken.setRememberMe(false);
        try{
            subject.login(usernamePasswordToken);
            System.out.println("success");
            return ResultFactory.buildSuccessResult(name);
        }catch (AuthenticationException e){
            String msg = "账号密码错误";
            return ResultFactory.buildFailResult(msg);
    }
    }

    @GetMapping("/user/logout")
    public Result loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String msg = "成功登出";
        return ResultFactory.buildSuccessResult(msg);
    }

    @GetMapping("/user/authentication")
    public String autoentication(){
        return "身份";
    }

    @GetMapping (value ="/user/getAllUser")
    public List<User> getUser(){
        List<User> users = userService.getAll();
        System.out.println(users);
        return users;

    }

    @PostMapping("/user/deleteUser")
    public void delete(@RequestBody User user){
        userService.deleteUser(user.getId());
    }

    @PostMapping("/admin/user/deleteUser")
    public Result deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/user/register")
   public Result register(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        //特殊字符转义
        name=HtmlUtils.htmlEscape(name);
        user.setName(name);

        Boolean exist = userService.findUserByName(name);
        if(exist != null){
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }
        else{
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();

            int times = 2;

            String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

            user.setSalt(salt);
            user.setPassword(encodedPassword);
            userService.addUser(user);
            return ResultFactory.buildSuccessResult(user);
        }

    }
    @PostMapping("/user/asd")
    public Boolean rsa(@RequestBody User user){
        return userService.findUserByName(user.getName());
    }

    @PutMapping("/admin/user/status")
    public Result updateUserStatus(@RequestBody  User user){
        userService.saveUser(user);
        return ResultFactory.buildSuccessResult("用户状态更新");
    }

    @GetMapping("/admin/user/getAlluser")
    public Result getAllUser(){
        return ResultFactory.buildSuccessResult(userService.getAll());
    }

    @PutMapping ("/admin/user")
    public Result changeUser(@RequestBody User user){
        User user2 = userService.findByName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPhone(user.getPhone());
        user2.setRoles(user.getRoles());
        System.out.println(user);
        System.out.println(user2);
        userService.saveUser(user2);
        adminUserRoleService.deleteAllByUid(user2.getId());
        AdminUserRole userRole = new AdminUserRole();
        List<AdminRole> roles = user.getRoles();


        for (AdminRole role : roles) {
            userRole.setUid(user2.getId());
            userRole.setRid(role.getId());
            adminUserRoleService.saveAdminUseridAndRoleid(userRole);
        }

        return ResultFactory.buildSuccessResult("修改成功");
    }

    @PutMapping("/admin/user/deleteAll")
    public Result deleteAll(@RequestBody List<User> id){
        System.out.println(id);
        for (User user : id) {
            userService.deleteUser(user.getId());
        }
        return ResultFactory.buildSuccessResult("成功删除");
    }

}
