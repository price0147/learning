package com.wangx.sys.serviceimpl;

import com.wangx.base.BaseResult;
import com.wangx.entities.SysUser;
import com.wangx.sys.dao.SysLoginUserDao;
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
    SysLoginUserDao sysLoginUserDao;
    @Override
    public BaseResult getById(Long id) {
        SysUser sysUser = sysLoginUserDao.getById(id);
        if(sysUser != null){
            return BaseResult.successResultCreate("查询成功", sysUser);
        }
        return BaseResult.failResultCreate("查询失败:可能不存在对应数据");
    }
}
