package com.cdivtc.service.impl;

import com.cdivtc.domain.Book;
import com.cdivtc.entity.PageResult;
import com.cdivtc.mapper.BookMapper;
import com.cdivtc.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    //注入BookMapper对象
    @Autowired
    private BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /*
    * 根据当前页码和每页需要展示的数据条数，查询最新上架的图书信息
    * @param pageNum当前页码
    * @param pageSize每页显示数量*/
    @Override
    public PageResult selectNewBooks(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Book> page=bookMapper.selectNewBooks();
        return new PageResult(page.getTotal(),page.getResult());
    }
    /*
    * 根据id查询图书信息
    * @param id 图书id
    * */
    @Override
    public Book findById(String id) {
        return bookMapper.findById(id);
    }
    /*
    * 借阅图书
    * @param book 申请借阅的图书*/
    @Override
    public Integer borrowBook(Book book) {
        //根据id查询出需要借阅的完整图书信息
        Book b = this.findById(book.getId()+"");
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        //设置当天为借阅时间
        book.setBorrowTime(dataFormat.format(new Date()));
        //设置所借阅的图书状态为借阅中
        book.setStatus("1");
        //将图书的价格设置在book对象中
        book.setPrice(b.getPrice());
        //将图书的上架设置在book对象中
        book.setUploadTime(b.getUploadTime());
        return bookMapper.editBook(book);
    }
}
