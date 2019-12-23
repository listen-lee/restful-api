package com.example.restfulapi.resource;/*
 * @program: restful-api
 *
 * @description: 错误资源
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:51
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ErrorResource {
    private String message;
}
