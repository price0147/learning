package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangxu
 * @date: 2020/3/24 20:16
 */
@SpringBootApplication
@Slf4j
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
