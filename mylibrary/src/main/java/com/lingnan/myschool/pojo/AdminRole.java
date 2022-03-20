package com.lingnan.myschool.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRole {
    private Integer id;
    private String name;
    private String name_zh;
    private Integer enabled;
    private List<AdminPermission> perms;
    private List<AdminMenu> menus;

}
