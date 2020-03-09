package com.wangx.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wangxu
 * @date: 2020/3/8 17:28
 */
@Configuration
public class ConfigBean {//boot -> spring applicationContext.xml @configuration配置 ConfigBean = applicationContext.xml
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//一般这个文件中放<bean id = "userService" class="com.wangx.userServiceImpl">相关内容
//和下面面配置是一个意思
//    @Bean
//    public userService getUserService(){
//        return new userServiceImpl;
//    }
//applicationContext.xml
