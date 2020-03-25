package com.wangx.sys.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: wangxu
 * @date: 2020/3/19 11:08
 */
public class WebConfigurer implements WebMvcConfigurer {
    //这个方法用来注册拦截器,我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    //这个方法用来配置静态资源的,比如html,js,css,等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
