package com.lingnan.myschool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String name;
    private String password;
    private String salt;
    private String phone;
    @Email(message = "请输入正确的邮箱")
    private String email;
    private Integer enabled;
    private List<AdminRole> roles;
}
