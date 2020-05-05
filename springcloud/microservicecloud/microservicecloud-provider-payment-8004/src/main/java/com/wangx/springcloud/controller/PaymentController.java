package com.wangx.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: wangxu
 * @date: 2020/5/4 15:22
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String serverPort(){
        return "port:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
