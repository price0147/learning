package com.wangx.springcloud.controller;

import com.wangx.springcloud.entities.CommonResult;
import com.wangx.springcloud.entities.Payment;
import com.wangx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/5/13 9:55
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer/payment")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> commonResult = paymentFeignService.getPaymentById(id);
        return commonResult;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign->riddon,客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
