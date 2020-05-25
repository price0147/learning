package com.wangx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: wangxu
 * @date: 2020/5/16 13:37
 */
@Service
public class PaymentService {


    /**
     * ===================服务降级示例代码
     */
    public String paymentInfo_OK(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    //在业务类上加上这个注解实现服务降级设置

    /**
     * fallbackMethod:如果这个方法出事了,就执行paymentInfo_TimeOutHandler这个方法进行兜底
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //设置超时时错误的时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {

        int time = 3;
        //测试需要->报错语句
        //int age = 10/0;
        try {
            //暂停time秒钟
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + "耗时(秒): " + time;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或者运行报错,请稍后重试,id: " + id + "\t" + "o(╥﹏╥)o";
    }


    /**
     * =====================服务熔断示例代码
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            //下面配置总体10秒钟内访问10次如果失败率达百分之60则跳闸,这里面的所有属性都在HystrixCommandProperties抽象类里面,这里面还提供了很多属性的默认值.
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t 调用成功,流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数,请稍后重试,╮(╯▽╰)╭ id:" + id;
    }

}
