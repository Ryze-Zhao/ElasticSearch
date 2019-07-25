package com.zhaostudy.elasticsearch;

import com.zhaostudy.elasticsearch.repository.domain.Book;
import com.zhaostudy.elasticsearch.service.EsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {
    @Autowired
    private EsService esService;
    @Test
    public void createIndex() {
        esService.createIndex(Book.class);
    }
    @Test
    public void deleteIndex() {
        esService.deleteIndex(Book.class);
    }
}
