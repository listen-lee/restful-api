package com.example.restfulapi.entity;/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-17 19:19
 */

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
public class Book {
    @Id
    private ObjectId id;
    //书名
    private String name;
    private String author;
    private String description;
    private boolean status;
}
