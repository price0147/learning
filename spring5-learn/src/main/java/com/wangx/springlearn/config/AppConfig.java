package com.wangx.springlearn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: wangxu
 * @date: 2020-12-24 17:43
 */
@ComponentScan("com.wangx.springlearn")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
