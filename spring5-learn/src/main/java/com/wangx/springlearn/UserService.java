package com.wangx.springlearn;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: wangxu
 * @date: 2020-12-22 21:07
 */
@Component
public class UserService {
    private String check;
    /*
    和IndexService形成
     */
    @Autowired
    IndexService indexService;

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    @PostConstruct
    public void initMethod() throws Exception {
        System.out.println("我是初始化方法");
    }
}
