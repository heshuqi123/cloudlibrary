package com.cdivtc.service;

import com.cdivtc.domain.Book;
import com.cdivtc.entity.PageResult;

/*
*
* 图书接口
* */
public interface BookService {
    //查询最新上架的图书
    PageResult selectNewBooks(Integer pageNum,Integer pageSize);
    //根据id查询图书信息
    Book findById(String id);
    //借阅图书
    Integer borrowBook(Book book);
}
