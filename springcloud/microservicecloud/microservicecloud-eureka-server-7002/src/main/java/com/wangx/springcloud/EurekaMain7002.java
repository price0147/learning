package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: wangxu
 * @date: 2020/4/9 17:35
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
