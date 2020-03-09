package com.wangx.webservice.webserviceCXFJaxws.interImpl;


import com.wangx.webservice.webserviceCXFJaxws.inter.HelloWebService;

/**
 * @author: wangxu
 * @date: 2020/1/9 21:12
 */
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public void hello() {
        System.out.println("我进来了");
    }
}
