package com.wangx.webservice.webserviceCXFJaxws;

import com.wangx.webservice.webserviceCXFJaxws.interImpl.WebServiceGiveImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Endpoint;


/**
 * @author: wangxu
 * @date: 2020/1/12 16:47
 */
//发布服务

public class PublishingService {
    //方法1
    public void giveService() {
        //创建一个发布服务的工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置发布地址
        factory.setAddress("http://localhost:8210/MyGod");
        //设置服务类
        factory.setServiceBean(new WebServiceGiveImpl());
        //发布服务
        Server server = factory.create();
        //开始服务
        server.start();
        //日志提示
        Logger logger = LoggerFactory.getLogger(PublishingService.class);
        logger.info("服务发布成功");
    }

    //方法2
    public void giveServiceTwo() {
        //设置发布地址
        String address = "http://localhost:8210/MyGod";
        //发布服务
        Endpoint.publish(address, new WebServiceGiveImpl());
        //日志提示
        Logger logger = LoggerFactory.getLogger(PublishingService.class);
        logger.info("服务发布");
    }
}
