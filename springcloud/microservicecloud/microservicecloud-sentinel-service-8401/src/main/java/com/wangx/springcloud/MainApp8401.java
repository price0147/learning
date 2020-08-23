package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wangxu
 * @date: 2020/8/12 15:49
 */
//开始注册发现功能
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class MainApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}

