package com.lingnan.myschool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMenu {
    private Integer id;
    private String  path;
    private String name;
    private String name_zh;
    private String icon_cls;
    private String component;
    private Integer parent_id;
    List<AdminMenu> children;

}
