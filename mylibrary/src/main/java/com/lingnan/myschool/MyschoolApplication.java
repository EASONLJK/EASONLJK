package com.lingnan.myschool;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@MapperScan("com.lingnan.myschool.mapper")
@ServletComponentScan(basePackages = "com.lingnan.myschool")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyschoolApplication.class, args);
    }

}
