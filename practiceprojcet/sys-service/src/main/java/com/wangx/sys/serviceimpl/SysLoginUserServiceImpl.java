package com.wangx.sys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangx.base.BaseResult;
import com.wangx.common.base.BaseServiceImpl;
import com.wangx.common.until.JwtUntil;
import com.wangx.entities.SysUser;
import com.wangx.sys.mapper.SysLoginUserMapper;
import com.wangx.sys.service.SysLoginUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/18 16:50
 */
@Service
public class SysLoginUserServiceImpl extends BaseServiceImpl<SysLoginUserMapper,SysUser, Map<String,Object>> implements SysLoginUserService {
    @Resource
    SysLoginUserService sysLoginUserService;

    @Override
    public BaseResult login(SysUser user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("USER_NAME", user.getUserName());
        SysUser sysUser = sysLoginUserService.getOne(wrapper);
        if (!sysUser.getUserName().equals(user.getUserName()) || !sysUser.getPassWord().equals(user.getPassWord())) {
            return BaseResult.failResultCreate("用户名或密码不正确");
        }
        //生产token
        String token = JwtUntil.generateToken(sysUser);
        return BaseResult.successResultCreate(token, "登录成功");
    }
}
