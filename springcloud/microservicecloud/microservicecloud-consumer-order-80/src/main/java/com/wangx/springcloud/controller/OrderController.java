package com.wangx.springcloud.controller;

import com.wangx.springcloud.entities.CommonResult;
import com.wangx.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/24 20:21
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

//    private final static String PAYMENT_URL = "http://localhost:8001";
    private final static String PAYMENT_URL = "http://MICROSERVICECLOUD-PAYMENT-SERVICE";

    //RestTemplate提供了多种便捷访问HTTP服务的方法是一种简单便捷的访问Restful服务模板类,
    //是Spring提供的用于访问Rest服务的客户端模板工具集
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/create")
    public CommonResult<Payment> creat(Payment payment){
        //使用restTemplate访问restful接口非常的简单粗暴无脑.
        //(url,requestMap,ResponseBean.class)
        //这三个参数分别代表REST请求地址,请求参数,HTTP响应转换被转换成的对象类
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/postForEntity/create")
    public CommonResult<Payment> creatPostForEntity(Payment payment){
        //使用restTemplate访问restful接口非常的简单粗暴无脑.
        //(url,requestMap,ResponseBean.class)
        //这三个参数分别代表REST请求地址,请求参数,HTTP响应转换被转换成的对象类
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new CommonResult<>(530,"PostForEntity操作失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") String id) {
        CommonResult<Payment> commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
        return commonResult;
    }

    /**
     * 使用getForEntity方法
     * @param id
     * @return
     */
    @GetMapping("/getForEntity/{id}")
    public CommonResult<CommonResult> getPaymentGetForEntity(@PathVariable("id") String id) {
        ResponseEntity<CommonResult> commonResult = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
        log.info(commonResult.getStatusCode() + "\n------------------\n" + commonResult.getHeaders() + "\n------------------\n" + commonResult.getStatusCodeValue());
        if(commonResult.getStatusCode().is2xxSuccessful()){
            return commonResult.getBody();
        }else{
            return new CommonResult<>(520, "GetForEntity操作失败");
        }

    }

}
