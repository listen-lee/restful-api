package com.example.restfulapi.resource;/*
 * @program: restful-api
 *
 * @description: 字段错误
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:52
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class FieldResource {
    /**
     * 实体对象
     */
    private String resource;
    /**
     * 字段
     */
    private String field;
    /**
     * 代码
     */
    private String code;
    /**
     * 具体信息
     */
    private String message;
}
