package com.wangx.webservice.webserviceCXFJaxws.config;

import com.wangx.webservice.webserviceCXFJaxws.PublishingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxu
 * @date: 2020/2/5 20:59
 */
@Configuration
public class CxfConfig {
    public void test(){
        Logger logger = LoggerFactory.getLogger(PublishingService.class);
        logger.info("我是配置类,我来向你证明他的运行时段");
    }
}
