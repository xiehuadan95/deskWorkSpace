package com.xie.service;

import com.xie.dao.BookMapper;
import com.xie.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //service调用dao层 组合
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }
    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }
    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }
    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }
    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookName(String bookName) {
        return bookMapper.queryBookName(bookName);
    }
}
