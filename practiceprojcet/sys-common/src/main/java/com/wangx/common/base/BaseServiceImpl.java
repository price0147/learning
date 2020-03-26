package com.wangx.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangx.base.BaseModel;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/25 13:47
 */
@Service
public abstract class BaseServiceImpl <Mapper extends BaseMapper<Record>,
        Record extends BaseModel,
        Para extends Map<String, Object>> extends ServiceImpl<Mapper, Record> implements BaseService<Record, Para> {
}
