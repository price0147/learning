package com.wangx.api;

import com.wangx.base.BaseResult;
import com.wangx.base.BaseService;
import com.wangx.entities.SysUser;

import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/18 16:49
 */
public interface SysLoginUserService extends BaseService<SysUser, Map<String,Object>> {

    public BaseResult login(SysUser sysUser);

}
