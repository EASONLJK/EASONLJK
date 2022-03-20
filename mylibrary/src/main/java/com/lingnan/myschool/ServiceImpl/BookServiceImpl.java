package com.lingnan.myschool.ServiceImpl;

import com.lingnan.myschool.Service.BookService;
import com.lingnan.myschool.mapper.BookMapper;
import com.lingnan.myschool.pojo.Book;
import com.lingnan.myschool.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> findAllByCategory(int cid) {

        return bookMapper.findAllByCategory(cid);
    }

    @Override
    public List<Book> findAllBook() {
        return bookMapper.findAllBook();
    }

    @Override
    public void addOrUpdateBook(Book book) {
        bookMapper.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookMapper.deleteBookById(id);
    }

    @Override
    public List<Book> findAllByTitleLikeOrAuthorLike(String keyword) {
        return bookMapper.findAllByTitleLikeOrAuthorLike(keyword,keyword);
    }
}
