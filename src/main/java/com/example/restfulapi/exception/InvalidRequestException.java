package com.example.restfulapi.exception;/*
 * @program: restful-api
 *
 * @description: 请求参数异常
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:32
 */

import lombok.Getter;
import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException {
    @Getter
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public InvalidRequestException(Errors errors) {
        this.errors = errors;
    }
}
