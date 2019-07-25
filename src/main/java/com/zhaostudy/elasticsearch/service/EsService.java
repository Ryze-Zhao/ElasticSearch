package com.zhaostudy.elasticsearch.service;


public interface EsService {

    void deleteIndex(Class t);

    void createIndex(Class t);
}
