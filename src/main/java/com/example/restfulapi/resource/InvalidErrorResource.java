package com.example.restfulapi.resource;/*
 * @program: restful-api
 *
 * @description: 信息封装
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:55
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class InvalidErrorResource {
    private String resource;
    private Object errors;
}
