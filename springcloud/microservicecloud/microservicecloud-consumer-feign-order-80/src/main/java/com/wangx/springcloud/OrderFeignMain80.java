package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: wangxu
 * @date: 2020/5/13 9:41
 */
@SpringBootApplication
//激活Feign
@EnableFeignClients
@Slf4j
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
