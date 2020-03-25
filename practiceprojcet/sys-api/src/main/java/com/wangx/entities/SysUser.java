package com.wangx.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("SYS_LONGIN_USER")
public class SysUser {
    @TableId
    private Long id;
    @TableField("USER_NAME")
    @ApiModelProperty(value = "用户名")
    private String UserName;
    @TableField("PASS_WORD")
    @ApiModelProperty(value = "密码")
    private String PassWord;
    @JsonIgnore
    @ApiModelProperty(value = "逻辑标识符(0:否,1:是)")
    @TableField("DEL_FLAG")
    @TableLogic
    private String DelFlag;
}
