package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: wangxu
 * @date: 2020/6/1 16:41
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
