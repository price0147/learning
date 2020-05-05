package com.wangx.sys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangx.base.BaseResult;
import com.wangx.base.BaseService;
import com.wangx.entities.SysUser;
import com.wangx.sys.mapper.SysLoginUserMapper;
import com.wangx.api.SysLoginUserService;
import com.wangx.sys.untils.JwtUntil;
import com.wangx.sys.untils.ValidUntil;
import com.wangx.sys.untils.verification.ObjNotBlankValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/18 16:50
 */
@Service
@Slf4j
public class SysLoginUserServiceImpl extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<SysLoginUserMapper, SysUser> implements SysLoginUserService, BaseService<SysUser, Map<String, Object>> {
    @Resource
    SysLoginUserService sysLoginUserService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public BaseResult login(SysUser user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("USER_NAME", user.getUserName());
        SysUser sysUser = sysLoginUserService.getOne(wrapper);
        ValidUntil validUntil = new ValidUntil().on(sysUser,new ObjNotBlankValidator());
        if(validUntil.isError()){
            log.info("" + validUntil.getResult());
            return BaseResult.failResultCreate("用户名不存在");
        }
        log.info("" + validUntil.getResult());
        if (!sysUser.getUserName().equals(user.getUserName()) || !sysUser.getPassWord().equals(user.getPassWord())) {
            return BaseResult.failResultCreate("用户名或密码不正确");
        }
        //生产token
        String token = JwtUntil.generateToken(sysUser);
        //将token存入redis
        stringRedisTemplate.opsForValue().set("token", token);
        return BaseResult.successResultCreate(token, "登录成功");
    }
}
