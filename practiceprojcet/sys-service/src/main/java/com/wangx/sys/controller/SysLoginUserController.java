package com.wangx.sys.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.wangx.api.SysLoginUserService;
import com.wangx.base.BaseResult;
import com.wangx.entities.SysUser;
import com.wangx.sys.untils.ValidUntil;
import com.wangx.sys.untils.verification.StringNotBlankValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

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
        ValidUntil validUntil = new ValidUntil()
                .on(sysUser.getUserName(), new StringNotBlankValidator("用户名"))
                .on(sysUser.getPassWord(), new StringNotBlankValidator("密码"));
        if(validUntil.isError()){
            log.info("" + validUntil.getResult());
            return BaseResult.failResultCreate("用户名和密码不能为空");
        }
        sysLoginUserService.login(sysUser);
        log.info("" + validUntil.getResult());
        return sysLoginUserService.login(sysUser);
    }


}
