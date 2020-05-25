package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: wangxu
 * @date: 2020/5/16 14:21
 */
@SpringBootApplication
@EnableFeignClients
@Slf4j
//启动断路器功能这个位置和@EnableCircuitBreaker作用是一样的
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
