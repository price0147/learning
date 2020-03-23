package com.wangx.sys.dao;

import com.wangx.entities.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wangxu
 * @date: 2020/3/18 15:19
 */
@Mapper
public interface SysLoginUserDao {
    public SysUser getById(Long id);
}
