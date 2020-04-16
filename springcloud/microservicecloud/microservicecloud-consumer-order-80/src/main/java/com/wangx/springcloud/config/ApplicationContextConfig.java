package com.wangx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wangxu
 * @date: 2020/3/24 20:26
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 将RestTemplate类注入到容器中
     */
    @Bean
    //赋予RestTemplate负载均衡能力(这样才能通过微服务名称调用服务)
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
