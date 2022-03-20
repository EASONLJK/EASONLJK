package com.lingnan.myschool.intercetor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1.配置拦截哪些请求 2.把配置放在容器中

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return true;
//        }
//        session.setAttribute("msg","请先登录");
//        response.sendRedirect("/");
//        request.setAttribute("msg","请先登录");
//        request.getRequestDispatcher("/").forward(request,response);
//        return false;

        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated() && !subject.isRemembered()){
            System.out.println(subject.isAuthenticated());
            System.out.println(subject.isRemembered());
            return false;
        }
        return true;
    }
}