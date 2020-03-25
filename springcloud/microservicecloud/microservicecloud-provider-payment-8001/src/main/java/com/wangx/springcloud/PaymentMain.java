package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangxu
 * @date: 2020/2/25 20:38
 */
@SpringBootApplication
@Slf4j
public class PaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }
}
