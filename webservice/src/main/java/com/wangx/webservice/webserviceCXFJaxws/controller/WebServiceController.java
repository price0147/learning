package com.wangx.webservice.webserviceCXFJaxws.controller;

import com.wangx.webservice.webserviceCXFJaxws.inter.WebServiceGive;
import com.wangx.webservice.webserviceCXFJaxws.serialization.IWebSvc;
import com.wangx.webservice.webserviceCXFJaxws.serialization.WebSvc;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: wangxu
 * @date: 2020/1/9 21:14
 */
@RestController
public class WebServiceController {
    @GetMapping("/")
    public void test() {
        IWebSvc iWebSvc = new WebSvc().getBasicHttpBindingIWebSvc();
        String str = "{\"j\":\"{Address:[1,2]}\",\"s\":\"CRRC_Service.RockWellService\",\"m\":\"DisplayOff\"}";
        String dates = "{\"j\":\"{OutTime:10}\",\"s\":\"CRRC_Service.RockWellService\",\"m\":\"GetLatestErrorInfo\"}";
        String date = iWebSvc.run(dates);
        System.out.println(date);

    }

    @GetMapping("/test")
    public String test01() {
        //测试自己服务
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8210/MyGod");
        jaxWsProxyFactoryBean.setServiceClass(WebServiceGive.class);
        WebServiceGive webServiceGive = (WebServiceGive) jaxWsProxyFactoryBean.create();
        String str = webServiceGive.sayHello("王旭");
        return str;

    }
}
