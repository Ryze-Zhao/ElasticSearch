package com.zhaostudy.elasticsearch.repository.repository;

import com.zhaostudy.elasticsearch.repository.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//ElasticsearchRepository<Book, String>，第一个是对应实体类，第二个是ID的类型
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findAllByBookNameLike(String bookName);
}
