package com.zhaostudy.elasticsearch.service;


import com.zhaostudy.elasticsearch.repository.domain.Book;

import java.util.List;

public interface BookService {
    void saveBookList(List<Book> bookList);
    List<Book> findAll();
    void deleteAll(List<Book> bookList);
    List<Book> findAllByBookNameLike(String bookName);
}
