package com.wangx.springlearn;

import jdk.nashorn.internal.runtime.Undefined;

public enum MethodExecutionStatus {
    END(1,"END"),
    BEGIN(0, "BEGIN"),
    UNDEFINED(-1,"UNDEFINED");

    private int code;
    private String msg;

    MethodExecutionStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(int code){
        for (MethodExecutionStatus methodExecutionStatus : MethodExecutionStatus.values()) {
            if(methodExecutionStatus.getCode() == code){
                return methodExecutionStatus.getMsg();
            }
        }
        return UNDEFINED.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
