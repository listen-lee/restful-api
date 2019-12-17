package com.example.restfulapi.repo;/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-17 20:12
 */

import com.example.restfulapi.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface BookRepository extends CrudRepository<Book, ObjectId> {

    @Override
    List<Book> findAll();

    @Query("{}")
    Stream<Book> findAllByCustomQueryWithStream();
}
