package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: wangxu
 * @date: 2020/5/26 22:10
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class GetaWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GetaWayMain9527.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
