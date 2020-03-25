package com.wangx.sys.service;

import com.wangx.base.BaseResult;
import com.wangx.entities.SysUser;

/**
 * @author: wangxu
 * @date: 2020/3/18 16:49
 */
public interface SysLoginUserService {
    public SysUser getByUser(SysUser sysUser);
}
