package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangxu
 * @date: 2020/3/9 18:25
 */
@SpringBootApplication
@Slf4j
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
