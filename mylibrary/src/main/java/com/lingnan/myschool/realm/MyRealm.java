package com.lingnan.myschool.realm;

import com.lingnan.myschool.Service.AdminPermissionService;
import com.lingnan.myschool.Service.UserService;
import com.lingnan.myschool.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String username = principalCollection.getPrimaryPrincipal().toString();
//        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从数据库中获取信息，然后返回认证信息
        String name = authenticationToken.getPrincipal().toString();
        User user = userService.getByName(name);
        if(!ObjectUtils.isEmpty(user))
        {
            String password = user.getPassword();
            String salt = user.getSalt();
            //参数4是提供当前的realm名字 this.getname()
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(name, password, ByteSource.Util.bytes(salt), getName());
            return authenticationInfo;
        }

            return null;


    }

}
