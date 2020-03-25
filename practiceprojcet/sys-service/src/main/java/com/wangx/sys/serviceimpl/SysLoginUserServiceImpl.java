package com.wangx.sys.serviceimpl;

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
    public SysUser getByUser(SysUser user) {
        SysUser sysUser = sysLoginUserMapper.selectById(1L);
        return sysUser;
    }
}
