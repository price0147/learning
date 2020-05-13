package com.wangx.springcloud.service;

import com.wangx.springcloud.entities.CommonResult;
import com.wangx.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wangxu
 * @date: 2020-5-13 09:45:03
 */
//这个注解可以使spring可以扫描的到(经常被拉下)
@Component
//用于提示寻找那一个服务.这里的变量是服务名称
@FeignClient(value = "MICROSERVICECLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    //告诉openfeign在上面的服务里找哪个接口
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
