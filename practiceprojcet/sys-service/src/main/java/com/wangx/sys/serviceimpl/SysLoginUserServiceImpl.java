package com.wangx.sys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangx.base.BaseResult;
import com.wangx.common.baseclass.BaseServiceImpl;
import com.wangx.constant.BaseConstants;
import com.wangx.entities.SysUser;
import com.wangx.sys.mapper.SysLoginUserMapper;
import com.wangx.sys.service.SysLoginUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: wangxu
 * @date: 2020/3/18 16:50
 */
@Service
public class SysLoginUserServiceImpl implements SysLoginUserService {
    @Resource
    SysLoginUserMapper sysLoginUserMapper;

    @Override
    public BaseResult login(SysUser user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("USER_NAME", user.getUserName());
        wrapper.eq(BaseConstants.DEL_FLAG, BaseConstants.DelFlag.NORMAL);

        return null;
    }

}
