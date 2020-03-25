package com.wangx.sys;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@MapperScan("*.Mapper")
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.wangx"})
@MapperScan("com.wangx.sys.mapper")
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
        log.info(">>>>>>>启动完成<<<<<<<");
    }
}
