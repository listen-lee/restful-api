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

import com.example.restfulapi.entity.Book;
import com.example.restfulapi.repo.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * GET /api/v1/books/{id}
     *
     * @return http 响应
     */
    @GetMapping("/books")
    public HttpEntity<?> books() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    /**
     * 获取一个书单
     *
     * @param id id
     * @return http响应
     */
    @GetMapping("/books/{id}")
    public HttpEntity<?> booksOne(@PathVariable String id) {
        Optional<Book> book = bookRepository.findById(new ObjectId(id));
        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    /**
     * 添加一个书单
     * POST /api/v1/books
     *
     * @param book       书单
     * @param bindResult 验证
     * @return http响应
     */
    @PostMapping("/books")
    public HttpEntity<?> booksAdd(@Valid @RequestBody Book book, BindingResult bindResult) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    /**
     * 更新一条书单，提供全部信息
     * PUT /api/v1/books/{id}
     *
     * @param id            更新数据id
     * @param book          更新后的书单
     * @param bindingResult 绑定结果
     * @return http 响应
     */
    @PutMapping("/books/{id}")
    public HttpEntity<?> booksPut(@PathVariable String id, @RequestBody @Valid Book book, BindingResult bindingResult) {
        Book save;
        Optional<Book> existBook = bookRepository.findById(new ObjectId(id));
        if (existBook.isPresent()) {
            book.setId(existBook.get().getId());
            save = bookRepository.save(book);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 更新一个书单,提供一个书单的部分信息
     * PATCH   /api/v1/books/{id}   更新一条书单，提供部分信息
     *
     * @param id   更新的id
     * @param book 更新后的书单
     * @return http 响应
     */
    @PatchMapping("/books/{id}")
    public HttpEntity<?> booksPatch(@PathVariable String id, @RequestBody Book book) {
        Optional<Book> existBook = bookRepository.findById(new ObjectId(id));
        if (existBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanWrapper beanWrapper = new BeanWrapperImpl(book);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if (beanWrapper.getPropertyValue(propertyDescriptor.getName()) == null) {
                nullPropertyNames.add(propertyDescriptor.getName());
            }
        }
        BeanUtils.copyProperties(book, existBook, nullPropertyNames.toArray(new String[0]));
        return new ResponseEntity<>(bookRepository.save(existBook.get()), HttpStatus.OK);
    }
}
