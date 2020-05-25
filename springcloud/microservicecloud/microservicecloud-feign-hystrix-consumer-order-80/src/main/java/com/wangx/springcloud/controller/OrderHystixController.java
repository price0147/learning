package com.wangx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangx.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/5/16 14:27
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer/payment")
//配置全局fallback方法,如果没有发现方法上面的@HystrixCommand,就执行本标签里的方法,如果有@HystrixCommand,就执行他对应的方法
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystixController {
    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") int id) {
        int i = 10/0;
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("#####result: " + result);
        return result;
    }

    /**
     * fallbackMethod:如果这个方法出事了,就执行paymentInfo_TimeOutHandler这个方法进行兜底
     * 如果出现错误调用全局fallback方法,如果不加这个注解,将不会调用任何回调方法
     * 注意:如果这个注解没有加fallbackMethod参数,就将全局回调方法作为回调方法,如果加了fallbackMethod参数,就用对应的方法作为回调方法)
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //设置超时时错误的时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping(value = "hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") int id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("#####result: " + result);
        return result;
    }

    public String paymentInfo_TimeOutHandler(int id){
        return "线程池: " + Thread.currentThread().getName() + " 系统80繁忙或者运行报错,请稍后重试,id: " + id + "\t" + "o(╥﹏╥)o";
    }

    //下面是全局fallback
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息,请稍后再试,╮(╯▽╰)╭";
    }

}
