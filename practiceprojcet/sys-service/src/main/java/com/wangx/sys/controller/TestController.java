package com.wangx.sys.controller;

import com.wangx.sys.untils.PropertFileUntil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangxu
 * @date: 2020/5/25 13:58
 */
@RestController
@RequestMapping(value = "/sys")
@Slf4j
@Api(value = "测试接口", description = "测试接口")
public class TestController {

    @GetMapping("/propertFileUntilTest")
    public String propertFileUntilTest(){
        PropertFileUntil propertFileUntil = PropertFileUntil.getPropertFileUntil();
        String str = propertFileUntil.getString("application-value.properties", "jwt.key");
        return str;
    }

}
