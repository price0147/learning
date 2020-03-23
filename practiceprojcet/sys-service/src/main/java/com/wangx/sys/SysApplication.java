package com.wangx.sys;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan("*.Mapper")
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.wangx"})
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
        log.info(">>>>>>>启动完成<<<<<<<");
    }
}
