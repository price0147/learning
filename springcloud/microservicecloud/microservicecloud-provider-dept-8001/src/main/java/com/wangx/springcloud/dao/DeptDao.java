package com.wangx.springcloud.dao;

import com.wangx.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/2/22 20:49
 */
//@Mapper或者在主方法上@mapperscan
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
