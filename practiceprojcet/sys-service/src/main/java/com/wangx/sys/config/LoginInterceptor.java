package com.wangx.sys.config;

/**
 * @author: wangxu
 * @date: 2020/4/1 15:09
 */

import com.wangx.sys.untils.JwtUntil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器配置
 */
@Configuration
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String path = request.getServletPath();
        String token = request.getHeader("Token");
        Claims claims = JwtUntil.getTokenInfo(token);
        log.info(claims.toString());*/
        return true;

    }
}
