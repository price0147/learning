package com.wangx.constant;

/**
 * 接口结果常量枚举类
 * Moded by weiiming on 2017/12/18.
 */
public enum ResultConstant {

    FAILED(0, "操作失败！请刷新重试" ),
    SUCCESS(1, "操作成功！" ),
    VALIDATOR(2, "输入错误！" );

    private int code;

    private String message;

    ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


}
