package com.wangx.alibabacloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wangxu
 * @date: 2020/6/23 21:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
