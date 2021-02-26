package com.wangx.springlearn.config;

import com.wangx.springlearn.IndexService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author: wangxu
 * @date: 2021-01-22 10:59
 */
@Component
public class MyBeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition indexService1 = configurableListableBeanFactory.getBeanDefinition("indexService");
        System.out.println(indexService1.getBeanClassName());
        IndexService indexService = (IndexService)configurableListableBeanFactory.getBean("indexService");
        indexService.setAge("哈哈哈.我修改了它,I'm Win!!");
    }
}
