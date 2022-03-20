package com.lingnan.myschool.filter;

import com.lingnan.myschool.Service.AdminPermissionService;
import com.lingnan.myschool.utils.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class URLPathMatchingFilter extends PathMatchingFilter {

    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //放行OPTIONS请求
        if(HttpMethod.OPTIONS.toString().equals((httpServletRequest).getMethod())){
            //所以对于一些提交到服务器处理的数据，只需要返回是否成功的情况下，可以考虑使用状态码204来作为返回信息，从而省掉多余的数据传输。
            //执行成功不会页面跳转或刷新
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        if(adminPermissionService == null){
            adminPermissionService = SpringContextUtils.getContext().getBean(AdminPermissionService.class);
        }
        //?
        String requestAPI = getPathWithinApplication(request);
        System.out.println("访问接口"+requestAPI);

        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            System.out.println("需要登录");
            return false;
        }

        boolean needFilter = adminPermissionService.needFilter(requestAPI);
        if(!needFilter){
            System.out.println("接口"+requestAPI+"无需权限");
            return true;
        }else {
            System.out.println("验证访问权限"+requestAPI);
            boolean hasPermission = false;
            String username = subject.getPrincipal().toString();

            Set<String> permissionAPIs = adminPermissionService.listPermissionURLsByUser(username);
            for (String api : permissionAPIs) {
                if(api.equals(requestAPI)){
                    hasPermission = true;
                    break;
                }

            }

            if(hasPermission){
                System.out.println("访问权限"+requestAPI+"验证成功");
                return true;
            }else{
                System.out.println("当前用户没有接口"+requestAPI+"的访问权限");
                return false;
            }

        }


    }
}
