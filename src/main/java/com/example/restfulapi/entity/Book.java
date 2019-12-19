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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Data
@Document
@RequiredArgsConstructor
public class Book {
    @Id
    private String id;
    //书名
    @NotNull(message = "书名不能为空")
    private String name;
    @NotNull(message = "作者名称不能为空")
    private String author;
    private String description;
    @NotNull(message = "状态不能为空")
    private boolean status;
}
