package com.wangx.practiceprojcet.practiceprojcet.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/16 16:11
 */
@RestController
public class RedisTestController {
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping(value = "/redis")
    public String test(){
        redisTemplate.opsForValue().set("myKey", "My Name is Wangx");
        String result = redisTemplate.opsForValue().get("myKey");
        System.out.println(result);
        return result;
    }
}
