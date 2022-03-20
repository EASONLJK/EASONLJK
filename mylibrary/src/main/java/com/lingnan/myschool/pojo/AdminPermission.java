package com.lingnan.myschool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPermission {
    private Integer id;
    private String  name;
    private String desc_;
    private String url;

}
