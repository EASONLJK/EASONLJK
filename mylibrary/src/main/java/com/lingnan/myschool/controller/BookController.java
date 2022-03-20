package com.lingnan.myschool.controller;

import com.lingnan.myschool.Service.BookService;
import com.lingnan.myschool.ServiceImpl.BookServiceImpl;
import com.lingnan.myschool.pojo.Book;
import com.lingnan.myschool.pojo.Category;
import com.lingnan.myschool.pojo.User;
import com.lingnan.myschool.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book/getAllBook")
    public List<Book> findAllBook(){
        List<Book> allBook = bookService.findAllBook();
        return allBook;
    }

    @GetMapping("/book/getBookBC/{cid}")
    public List<Book> getBookByCategory(@PathVariable("cid") int cid){
        if(cid == 0){
            return bookService.findAllBook();
        }else{
            return bookService.findAllByCategory(cid);
        }

    }

    @PostMapping(value = "/book/saveBook",produces = "application/text;charset=UTF-8")
    public void addOrUpdateBook(@RequestBody Book book){
        bookService.addOrUpdateBook(book);
    }

    @PostMapping("/book/deleteBook")
    public void deleteBookById(@RequestBody User user){
        bookService.deleteBookById(user.getId());
    }

    @GetMapping("/book/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)) {
            return bookService.findAllBook();
        } else {
            return bookService.findAllByTitleLikeOrAuthorLike(keywords);
        }

    }

    @PostMapping("/book/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8081/book/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
