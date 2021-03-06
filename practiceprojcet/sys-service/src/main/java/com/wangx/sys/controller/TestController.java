package com.wangx.sys.controller;

import com.wangx.sys.untils.PropertFileUntil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangxu
 * @date: 2020/5/25 13:58
 */
@RestController
@Slf4j
@Api(value = "测试接口", description = "测试接口")
@RefreshScope //支持Nacos的动态刷新功能
public class TestController {

    @GetMapping("/propertFileUntilTest")
    public String propertFileUntilTest(){
        PropertFileUntil propertFileUntil = PropertFileUntil.getPropertFileUntil();
        String str = propertFileUntil.getString("application-dev.properties", "jwt.key");
        return str;
    }

    @GetMapping("sys/t1")
    public String t1(){
        return "hello";
    }

    @GetMapping("syss/t1")
    public String t2(){
        return "hey";
    }

}
