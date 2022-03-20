//package com.lingnan.myschool.config;
//
//
//import com.lingnan.myschool.intercetor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AdminWebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")  //所有请求包括静态资源拦截
//                .excludePathPatterns("/","/login","/mapper/**","/mybatis/**","/user/**","/book/**","/admin/**");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/book/file/**").addResourceLocations("file:" + "d:/workspace/img/");
//    }
//}