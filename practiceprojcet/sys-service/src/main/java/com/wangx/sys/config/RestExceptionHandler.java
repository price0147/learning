package com.wangx.sys.config;

import com.wangx.base.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: wangxu
 * @date: 2020/3/26 15:15
 */
//这个注解是Spring3.0以后的一个Controller的增强,他会作用在一起使用requestMapping的方法上,
//并且被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，都会作用在 被 @RequestMapping 注解的方法上。(Spring里面的方法增强)
//目前的理解类似于使用了Spring里的通知,理解还不深刻(请自行百度)
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    /**
     * 校验错误拦截处理
     * 使用@RequestBody接收入参时,校验失败抛MethodArgumentNotValidException 异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResult handler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException handler", e);
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasFieldErrors()) {
            return BaseResult.failResultCreate(bindingResult.getFieldError().getDefaultMessage());
        }
        return BaseResult.failResultCreate("parameter is not valid");
    }

    /**
     * 校验错误拦截处理
     * 使用 @RequestBody 接收入参时，数据类型转换失败抛 HttpMessageConversionException 异常
     */
    @ExceptionHandler(value = HttpMessageConversionException.class)
    public BaseResult handler(HttpMessageConversionException e) {
        log.error("HttpMessageConversionException handler", e);
        return BaseResult.failResultCreate(e.getMessage());
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResult handler(Exception e) {
        log.error("exception handler", e);
        return BaseResult.failResultCreate(e.getMessage());
    }
}
