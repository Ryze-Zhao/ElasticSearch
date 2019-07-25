package com.zhaostudy.elasticsearch.service.impl;

import com.zhaostudy.elasticsearch.repository.domain.Book;
import com.zhaostudy.elasticsearch.repository.repository.BookRepository;
import com.zhaostudy.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    //增加和修改
    @Override
    public void saveBookList(List<Book> bookList) {
        bookRepository.saveAll(bookList);
    }

    //查找全部
    @Override
    public List<Book> findAll() {
        List<Book> list =new ArrayList<>();
        bookRepository.findAll().forEach(e->list.add(e));
        return list;
    }

    //删除,是根据ID删除的，所以要保证id正确
    @Override
    public void deleteAll(List<Book> bookList) {
        bookRepository.deleteAll(bookList);
    }
    //根据书名模糊查询
    @Override
    public List<Book> findAllByBookNameLike(String bookName) {
        return bookRepository.findAllByBookNameLike(bookName);
    }
}
