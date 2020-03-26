package com.wangx.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangx.base.BaseResult;
import com.wangx.common.base.BaseServiceImpl;
import com.wangx.constant.BaseConstants;
import com.wangx.entities.SysUser;
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
@Api(value = "用户接口", description = "用户管理")
public class SysLoginUserController {
    @Resource
    SysLoginUserService sysLoginUserService;


    @ApiOperation(value = "登录接口", response = SysUser.class)
    @PostMapping(value = "/login")
    public Object logIn(SysUser sysUser) {
        //todo:这个位置以后要改成校验框架
        if (sysUser.getUserName() == null || sysUser.getPassWord() == null) {
            return BaseResult.failResultCreate("用户名和密码不能为空");
        }
        return sysLoginUserService.login(sysUser);
    }

}
