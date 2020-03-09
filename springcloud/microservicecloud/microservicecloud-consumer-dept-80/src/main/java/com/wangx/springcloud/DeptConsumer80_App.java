package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangxu
 * @date: 2020/3/8 18:29
 */
@SpringBootApplication
@Slf4j
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}