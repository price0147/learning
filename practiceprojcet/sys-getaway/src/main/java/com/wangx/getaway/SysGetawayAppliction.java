package com.wangx.getaway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wangxu
 * @date: 2020/7/2 15:37
 */
//开始注册发现功能
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class SysGetawayAppliction {
    public static void main(String[] args) {
        SpringApplication.run(SysGetawayAppliction.class, args);
        log.info(">>>>>>>启动完成<<<<<<<");
    }
}
