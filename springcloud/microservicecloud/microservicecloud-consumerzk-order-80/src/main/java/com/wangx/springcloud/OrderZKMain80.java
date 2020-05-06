package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wangxu
 * @date: 2020/5/5 17:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class OrderZKMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderZKMain80.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }

}
