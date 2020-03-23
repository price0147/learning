package com.wangx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wangxu
 * @date: 2020/3/18 14:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Long id;
    private String UserName;
    private String PassWord;
}
