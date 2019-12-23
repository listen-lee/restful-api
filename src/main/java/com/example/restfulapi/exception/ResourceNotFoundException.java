package com.example.restfulapi.exception;/*
 * @program: restful-api
 *
 * @description: 资源未找到异常
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:31
 */

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
