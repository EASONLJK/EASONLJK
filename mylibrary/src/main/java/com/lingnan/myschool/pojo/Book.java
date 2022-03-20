package com.lingnan.myschool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
                 int id;
    private Category category;
                String cover;
                String title;
                 String author;
                 String date;
                 String press;
                 String abs;
                 String cid;
}
