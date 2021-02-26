package com.wangx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangxu
 * @date: 2020/12/5 17:52
 */
@SpringBootApplication
@Slf4j
public class MainRun {
    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
        log.info(">>>>启动完成<<<<");
    }
}
