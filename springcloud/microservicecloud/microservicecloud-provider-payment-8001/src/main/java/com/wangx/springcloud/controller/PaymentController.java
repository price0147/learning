package com.wangx.springcloud.controller;

import com.wangx.springcloud.entities.CommonResult;
import com.wangx.springcloud.entities.Payment;
import com.wangx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/17 20:15
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入运行结果" + result);
        if(result > 0){
            return new CommonResult(200, "插入成功", result);
        }
        return new CommonResult(500, "插入失败", result);
    }
    @GetMapping(value = "get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200, "查询成功", payment);
        }
        return new CommonResult(500, "查询失败", null);

    }

}
