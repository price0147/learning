package com.wangx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wangxu
 * @date: 2020/5/16 14:24
 */
@Component
//feign调用方式
@FeignClient(value = "MICROSERVICECLOUD-HYSTRIX-PROVIDER-PAYMENT")
public interface PaymentHystrixService {
    //注解标识调用MICROSERVICECLOUD-HYSTRIX-PROVIDER-PAYMENT这个微服务下的payment/hystrix/ok/{id}服务
    @GetMapping(value = "payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")int id);



    @GetMapping(value = "payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")int id);
}
