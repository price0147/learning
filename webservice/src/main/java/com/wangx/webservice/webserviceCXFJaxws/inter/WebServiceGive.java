package com.wangx.webservice.webserviceCXFJaxws.inter;

import javax.jws.WebService;

/**
 * @author: wangxu
 * @date: 2020/1/12 16:39
 */
//webService提供服务
@WebService
public interface WebServiceGive {
    public String sayHello(String name);

    public int saySorry(String name);
}
