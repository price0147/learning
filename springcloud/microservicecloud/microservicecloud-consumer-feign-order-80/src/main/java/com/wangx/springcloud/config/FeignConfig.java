package com.wangx.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxu
 * @date: 2020/5/14 22:31
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //放回bean并设置日志等级
        return Logger.Level.FULL;
    }
}