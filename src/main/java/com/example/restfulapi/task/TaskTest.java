package com.example.restfulapi.task;/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2020-01-02 10:42
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class TaskTest {
    @Scheduled(cron = "*/5 * * * * ?")
    public void test1() {
        log.error("test1-date-time-start: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error("sleep-error", e);
        }
        log.error("test1-date-time-end: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Scheduled(cron = "*/6 * * * * ?")
    public void test2() {
        log.error("test2-date-time-start: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error("sleep-error", e);
        }
        log.error("test2-date-time-end: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

