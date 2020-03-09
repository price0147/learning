package com.wangx.webservice.webserviceCXFJaxws.interImpl;

import com.wangx.webservice.webserviceCXFJaxws.inter.WebServiceGive;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author: wangxu
 * @date: 2020/1/12 16:42
 */
@Service
@WebService(serviceName = "com.wangx.webservice.webserviceCXFJaxws.interImpl.WebServiceGiveImpl", targetNamespace = "http://interImpl.webserviceCXFJaxws.webservice.wangx.com/", endpointInterface = "com.wangx.webservice.webserviceCXFJaxws.inter.WebServiceGive")
public class WebServiceGiveImpl implements WebServiceGive {
    @Override
    public String sayHello(String name) {
        return name + "我是webservice提供方";
    }

    @Override
    public int saySorry(String name) {
        return 0;
    }

}
