package com.lingnan.myschool.mapper;

import com.lingnan.myschool.pojo.Book;
import com.lingnan.myschool.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findAllByCategory(int cid);
   List<Book> findAllByTitleLikeOrAuthorLike(@Param("k1") String keyword1, @Param("k2") String keyword2);
    List<Book> findAllBook();
    void saveBook(Book book);
    void deleteBookById(Integer id);

}
