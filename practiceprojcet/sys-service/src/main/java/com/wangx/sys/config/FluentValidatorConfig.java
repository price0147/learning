package com.wangx.sys.config;

import com.baidu.unbiz.fluentvalidator.ValidateCallback;
import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxu
 * @date: 2020/3/26 14:17
 *
 * 注册 ValidateCallback 及 FluentValidateInterceptor，并且配置一个 AOP 规则
 *
 */
@Configuration
public class FluentValidatorConfig {
    @Bean
    public FluentValidateInterceptor fluentValidateInterceptor(){
        FluentValidateInterceptor fluentValidateInterceptor = new FluentValidateInterceptor();
        fluentValidateInterceptor.setCallback(validateCallback());
        return fluentValidateInterceptor;
    }
    @Bean
    public ValidateCallback validateCallback(){
        return new HussarValidateCallBack();
    }
    //使用BeanNameAutoProxyCreator来创建代理
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        //设置要创建代理的那些Bean的名字
        proxyCreator.setBeanNames("*Controller");
        //设置拦截链名字(这些拦截器是有先后顺序的)
        proxyCreator.setInterceptorNames("fluentValidateInterceptor");
        return proxyCreator;

    }
}
