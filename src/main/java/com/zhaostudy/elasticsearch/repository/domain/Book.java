package com.zhaostudy.elasticsearch.repository.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "book",type = "book")
public class Book {
    @Id
    private String id;

    /**
     * 标题
     * FieldType.Text会自动分词，ik_max_word使用ik分词器（需要安装）
     */
    @Field(type = FieldType.Keyword)
    private String bookName;

    /**
     * 内容
     * FieldType.Text会自动分词，ik_max_word使用ik分词器（需要安装）
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;
}



