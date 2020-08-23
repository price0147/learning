package com.wangx.springcloud.controller;

import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: wangxu
 * @date: 2020/8/12 15:22
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(2000);
        return "+++TestA++++";
    }

    @GetMapping("/testB")
    public String testB(){
        return "+++TestB++++";
    }
}
