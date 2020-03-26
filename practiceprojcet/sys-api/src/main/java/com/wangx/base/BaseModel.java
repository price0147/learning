package com.wangx.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/3/26 9:28
 */
//@JsonIgnoreProperties(ignoreUnknown = true)，将这个注解写在类上之后，就会忽略类中不存在的字段。这个注解还可以指定要忽略的字段
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BaseModel {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    protected String id;

    /**
     * 删除标记
     */
    //jackson注解作用是:此注解用于属性或者方法上(最好是属性上),作用是json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
    @JsonIgnore
    @TableField("del_flag")
    //标识逻辑删除,这个是myBits的注解,加上这个注解将本来的删除操作改成逻辑删除操作.
    @TableLogic
    @ApiModelProperty(value = "删除标记（0：正常；1：删除")
    protected String delFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    protected String remarks;

    /**
     * 创建者
     */
    @JsonIgnore
    @ApiModelProperty(value = "创建者")
    protected String createBy;

    /**
     * 创建时间
     */
    //@JsonIgnore
    //@JSONField(serialize = false)
    @ApiModelProperty(value = "创建时间")
    protected Date createDate;

    /**
     * 更新者
     */
    @JsonIgnore
    @ApiModelProperty(value = "更新者")
    protected String updateBy;

    /**
     * 更新时间
     */
    //@JsonIgnore
    //@JSONField(serialize = false)
    @ApiModelProperty(value = "更新时间")
    protected Date updateDate;

    /**
     * 行状态
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "行状态：Added 添加, Modified 修改, Unchanged 无变化, Deleted 删除")
    protected String rowState;


    /**
     * 按钮及链接对象
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "返回结果中提供链接 按钮及链接对象")
    protected List<Object> links = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //todo:了解这段代码是干什么用的.
    /*@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }*/
}
