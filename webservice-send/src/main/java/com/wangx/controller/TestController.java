package com.wangx.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.namespace.QName;


/**
 * @author: wangxu
 * @date: 2020/12/5 17:53
 */
@RestController
public class TestController {
    String wsdlUrl = "http://172.19.7.48/dlcru8webapi/dlcru8webservice.asmx?WSDL";
    String name_space = "http://tempuri.org/";

    @GetMapping("/testController")
    public Object testController(){
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        // wsdlUrl webservice地址，加上?wsdl后缀

        Client client = clientFactory.createClient(wsdlUrl);
        // name_space 命名空间
        QName qName = new QName(name_space, "HelloWorld");
        try {
            //参数数组
            Object[] param = new Object[]{};
            //方法名参数
            Object[] res = client.invoke("HelloWorld",param);
            // 处理结果res[0]
            JSONObject jsonObject = JSONObject.parseObject(String.valueOf(res[0]));
            // 业务
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "异常";
    }
}
