package com.lingnan.myschool.Service;

import com.lingnan.myschool.pojo.Book;
import com.lingnan.myschool.pojo.Category;


import java.util.List;

public interface BookService {
    List<Book> findAllByCategory(int cid);
    List<Book> findAllBook();
    void addOrUpdateBook(Book book);
    void deleteBookById(Integer id);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword);
}
