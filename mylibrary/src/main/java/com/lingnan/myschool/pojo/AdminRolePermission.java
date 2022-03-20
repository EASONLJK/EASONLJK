package com.lingnan.myschool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRolePermission {
    private Integer id;
    private Integer rid;
    private Integer pid;

}
