package com.wangx.sys.controller;

import com.wangx.entities.SysUser;
import com.wangx.sys.service.SysLoginUserService;
import com.wangx.sys.until.JwtUntil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wangxu
 * @date: 2020/3/18 15:16
 */
@Controller
@RequestMapping(value = "/sys")
@Slf4j
public class SysLoginUserController {
    @Autowired
    SysLoginUserService sysLoginUserService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @PostMapping(value = "/login")
    public Object logIn(SysUser sysUser){

        return null;
    }
    @GetMapping(value = "redistest")
    public void redistest(){
        stringRedisTemplate.opsForValue().set("wangx","程序员");
        log.info("-------------------存储完成---------------");
        String str = stringRedisTemplate.opsForValue().get("wangx");
        log.info("-------------------获取完成---------------"+str);
        stringRedisTemplate.delete("wangx");
        log.info("-------------------删除完成---------------");
    }
    @GetMapping(value = "jwttest")
    public void jwtTest(){
        SysUser sysUser = new SysUser(5L,"wang", "王");
        String token =  JwtUntil.generateToken(sysUser);
        log.info("=====获取Token=====" + token);

        Claims claims = JwtUntil.getTokenInfo(token,"wangx");
        log.info("=====Sub:====="+claims.getSubject());
        log.info("=====created:====="+claims.get("created"));
        log.info("=====Issuer:====="+claims.getIssuer());
        log.info("=====Audience:====="+claims.getAudience());
    }

}
