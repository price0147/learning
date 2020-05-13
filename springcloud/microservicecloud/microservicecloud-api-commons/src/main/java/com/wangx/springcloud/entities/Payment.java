package com.wangx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: wangxu
 * @date: 2020/3/15 18:49
 */
@Data
@AllArgsConstructor//lombok全参构造函数
@NoArgsConstructor//空参构造函数
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
