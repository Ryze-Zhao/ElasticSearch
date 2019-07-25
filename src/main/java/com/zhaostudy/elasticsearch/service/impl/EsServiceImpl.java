package com.zhaostudy.elasticsearch.service.impl;


import com.zhaostudy.elasticsearch.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class EsServiceImpl implements EsService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void createIndex(Class t) {
        elasticsearchTemplate.createIndex(t);
        //这句可以不加
        elasticsearchTemplate.putMapping(t);
    }

    @Override
    public void deleteIndex(Class t) {
        elasticsearchTemplate.deleteIndex(t);
    }
}
