package com.example.restfulapi.controller;
/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-17 20:21
 */

import com.example.restfulapi.repo.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest 风格 api
 * GET /api/v1/books        所有书单
 * GET /api/v1/books/{id}   获取一条书单
 * POST /api/v1/books       新建一条书单
 * PUT /api/v1/books/{id}   更新一条书单，提供全部信息
 * PATCH /api/v1/books/{id} 更新一条书单，提供全部信息
 * DELETE /api/v1/book/{id} 删除一条书单
 * DELETE /api/v1/books     删除所有书单
 */
@RestController
@RequestMapping("/v1")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 获取所有书单
     * GET /api/v1/books
     *
     * @return http 响应
     */
    @GetMapping("/books")
    public HttpEntity<?> books() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public HttpEntity<?> booksOne(@PathVariable String id) {
        return new ResponseEntity<>(bookRepository.findById(new ObjectId(id)), HttpStatus.OK);
    }

}
