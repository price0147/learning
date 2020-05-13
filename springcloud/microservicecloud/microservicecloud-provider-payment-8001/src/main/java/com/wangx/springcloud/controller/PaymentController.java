package com.wangx.springcloud.controller;

import com.wangx.springcloud.entities.CommonResult;
import com.wangx.springcloud.entities.Payment;
import com.wangx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    @Resource
    private String serverPort;

    //DiscoveryClient这是一个服务发现的对象,发现一些自己的基础信息比如:端口号,服务名
    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入运行结果" + result);
        if(result > 0){
            return new CommonResult(200, "插入成功,serverPort" + serverPort, result);
        }
        return new CommonResult(500, "插入失败", result);
    }

    @GetMapping(value = "get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200, "查询成功,serverPort" + serverPort, payment);
        }
        return new CommonResult(500, "查询失败", null);

    }
    @GetMapping(value = "/discovery")
    public Object discovery(){
        //获取服务清单列表(方式一)
        List<String> service = discoveryClient.getServices();
        service.forEach(x -> log.info("********" + x));

        //通过服务名获取对应服务名下的Instance实例
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-PAYMENT-SERVICE");
        instances.forEach(x -> log.info(x.getServiceId() + "\t" + x.getHost() + "\t" + x.getInstanceId() + "\t" + x.getPort() + "\t" + x.getUri()));
        return discoveryClient;
    }

    @GetMapping(value = "feign/timeout")
    public String paymentFeignTimeout(){

        //暂停3秒钟
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;

    }

}
