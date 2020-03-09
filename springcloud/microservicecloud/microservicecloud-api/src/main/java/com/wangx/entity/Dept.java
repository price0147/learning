package com.wangx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: wangxu
 * @date: 2020/2/19 21:49
 */
//Dept(Entity) orm mysql -> Dept(table) 类表关系映射

//lombok注解
@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //空参的构造函数
@Data //get,set方法
@Accessors(chain = true) //支持链式写法 (dept.setDb_source("2").setDname("1").setDeptno(1L);)
public class Dept implements Serializable {
    private Long deptno; //主键
    private String dname; //部门名称
    private String db_source; //来自哪个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同数据库

}
