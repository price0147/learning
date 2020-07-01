package com.wangx.alibabacloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wangxu
 * @date: 2020/6/22 14:25
 */
@RestController
@RequestMapping(value = "/payment/nacos")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/{id}")
    public String echo(@PathVariable("id") String id) {
        return "Nacos registry " + serverPort +"\t id = " + id;
    }

}
