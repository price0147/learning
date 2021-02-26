package com.wangx.springlearn.config;

import com.wangx.springlearn.testClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxu
 * @date: 2021-01-28 15:00
 */
@Configuration
public class PostProcessorConfig implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof testClass){
            ((testClass) bean).setAge("我进来了问题.");
            return bean;
        }
        return bean;
    }
}
