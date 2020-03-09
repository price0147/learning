package com.wangx.springcloud.controller;

import com.wangx.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/3/8 17:54
 */
@RestController
@RequestMapping(value = "/consumer/dept")
public class DeptController_Consumer {
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    //RestTemplate提供多种便捷访问远程Http服务的方法
    //是一种简单便捷的访问Restful服务模板类,是Spring提供的用于访问客户端模板工具集.
    /**
     * 使用:
     *      (url,requestMap,ResonseBean.class)
     *      这三个参数代表(REST请求地址,请求参数,HTTP响应装换被转换成的对象类型
     */
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }
    @GetMapping(value = "/get/{id}")
    public Dept add(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get?id=" + id,Dept.class);
    }
    @GetMapping(value = "/list")
    public List<Dept> add() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

}
