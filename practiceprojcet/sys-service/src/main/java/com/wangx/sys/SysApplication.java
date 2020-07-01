package com.wangx.sys;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@MapperScan("*.Mapper")
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.wangx"})
@MapperScan("com.wangx.sys.mapper")
//开始注册发现功能
@EnableDiscoveryClient
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
        log.info(">>>>>>>启动完成<<<<<<<");
    }
}
