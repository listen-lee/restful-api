package com.example.restfulapi.common;/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-24 10:12
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@Slf4j
public class CommonTest {
    @Test
    public void uuid() {
        log.info("test:{}", UUID.randomUUID());
    }
}
