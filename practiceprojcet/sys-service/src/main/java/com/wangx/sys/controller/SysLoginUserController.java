package com.wangx.sys.controller;

import com.wangx.base.BaseResult;
import com.wangx.entities.SysUser;
import com.wangx.sys.mapper.SysLoginUserMapper;
import com.wangx.sys.service.SysLoginUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/18 15:16
 */
@RestController
@RequestMapping(value = "/sys")
@Slf4j
@Api(value = "用户管理相关接口",description = "用户管理系统")
public class SysLoginUserController {
    @Resource
    SysLoginUserService sysLoginUserService;

    @Resource
    SysLoginUserMapper sysLoginUserMapper;

    @ApiOperation(value = "测试接口", response = SysUser.class)
    @PostMapping(value = "/login")
    public Object logIn(SysUser sysUser){
        SysUser users = sysLoginUserMapper.selectById(1L);
        //todo:这个位置以后要改成校验框架
        return BaseResult.successResultCreate(users);
    }

}
