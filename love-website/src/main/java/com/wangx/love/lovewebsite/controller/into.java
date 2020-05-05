package com.wangx.love.lovewebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wangxu
 * @date: 2020/4/1 14:18
 */
@Controller
public class into {
    @GetMapping(value = "/into")
    public String into(){
        return "玫瑰花.html";
    }
}
