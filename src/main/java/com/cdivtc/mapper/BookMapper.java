package com.cdivtc.mapper;

import com.cdivtc.domain.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface BookMapper {
    @Select("SELECT * FROM book where book_status !='3' order by book_uploadtime DESC")
    @Results(id = "bookMap",value = {
            //id字段默认为false,表示你不是主键
            //column表示数据库表字段，property表示实体类属性名
            @Result(id = true,column = "book_id",property = "id"),
            @Result(column = "book_name",property = "name"),
            @Result(column = "book_isbn",property = "isbn"),
            @Result(column = "book_press",property = "press"),
            @Result(column = "book_author",property = "author"),
            @Result(column = "book_pagination",property = "pagination"),
            @Result(column = "book_price",property = "price"),
            @Result(column = "book_uploadTime",property = "uploadTime"),
            @Result(column = "book_status",property = "status"),
            @Result(column = "book_borrower",property = "borrower"),
            @Result(column = "book_borrowTime",property = "borrowTime"),
            @Result(column = "book_returnTime",property = "returnTime"),
    })
    Page<Book> selectNewBooks();

    @Select("SELECT * FROM book where book_id=#{id}")
    @ResultMap("bookMap")
    //根据id查询图书信息
    Book findById(String id);
    //编辑图书信息
    Integer editBook(Book book);
}
