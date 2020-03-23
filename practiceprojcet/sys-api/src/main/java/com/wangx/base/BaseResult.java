package com.wangx.base;

import com.google.common.collect.Lists;
import com.wangx.constant.ResultConstant;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/3/17 14:37
 */
public class BaseResult implements Serializable {
    /**
     * 业务错误
     */
    public static final int FAILED = 0;

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 验证报错返回2
     */
    public static final int VALIDATOR = 2;

    // 状态码：1成功，其他为失败
    private int code;

    // 成功为success，其他为失败原因
    private String message;

    // 数据结果集
    private Object data;

    /**
     * 空构造器(增加原因：在dubbo使用Hessian反序列化时，使用此构造器，避免参数非默认类型引发空指针异常）
     */
    public BaseResult() {
    }

    public BaseResult(String message) {
        this.message = message;
    }

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult failResultCreate(String message) {
        return new BaseResult(FAILED, message, null);
    }

    /**
     * @param message 错误提示信息
     * @param data    错误详细信息（具体数据信息）
     * @return BaseResult
     */
    public static BaseResult failResultCreate(String message, Object data) {
        return new BaseResult(FAILED, message, data);
    }

    /**
     * 返回成功信息：
     *
     * @param data Get：传入的是查询业务数据
     * @return BaseResult
     */
    public static BaseResult successResultCreate(Object data) {
        return new BaseResult(SUCCESS, ResultConstant.SUCCESS.getMessage(), data);
    }

    /**
     * 返回成功信息
     *
     * @param message 自定义前台显示成功信息
     * @param data    业务数据
     * @return BaseResult
     */
    public static BaseResult successResultCreate(String message, Object data) {
        return new BaseResult(SUCCESS, message, data);
    }

    /**
     * 验证信息失败（前台未使用message字段，直接使用data，此处返回一条验证失败信息）
     * 前台可接收data类型为List
     *
     * @param data 验证信息
     * @return BaseResult
     */
    public static BaseResult validatorResultCreate(String data) {
        List<ResultValidator> messageList = Lists.newArrayList();
        messageList.add(new ResultValidator(data));
        return new BaseResult(BaseResult.VALIDATOR, ResultConstant.VALIDATOR.getMessage(), messageList);
    }

    /**
     * 验证返回数据是否为1
     *
     * @param didCount 处理数据量
     * @return BaseResult
     */
    public static BaseResult checkCountOneResult(int didCount) {
        return checkCountResult(didCount, 1);
    }

    /**
     * 验证返回值是否一致
     *
     * @param didCount    处理数据
     * @param willDoCount 期望数据条数
     * @return BaseResult
     */
    public static BaseResult checkCountResult(int didCount, int willDoCount) {
        BaseResult result = new BaseResult();
        if (didCount <= 0) {
            result.setCode(FAILED);
            result.setMessage("处理失败");
        } else if (didCount < willDoCount) {
            result.setCode(SUCCESS);
            result.setMessage("批量操作部分成功！");
        } else {
            result.setCode(SUCCESS);
            result.setMessage("操作成功");
        }

        result.setData(didCount);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取返回结果状态是否成功
     *
     * @return boolean
     */
    public boolean isSuccess() {
        if (SUCCESS == code) {
            return true;
        } else {
            return false;
        }
    }
}
