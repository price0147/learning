package com.wangx.springlearn;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.EventObject;

/**
 * 事件类
 * @author: wangxu
 * @date: 2021-02-12 21:10
 */

public class ApplicationMethodExecutionEvent extends ApplicationEvent {
    protected String methodName;
    protected MethodExecutionStatus methodExecutionStatus;


    public ApplicationMethodExecutionEvent(Object source) {
        super(source);
    }

    public ApplicationMethodExecutionEvent(Object source, String methodName, MethodExecutionStatus methodExecutionStatus) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getMethodExecutionStatus() {
        return methodExecutionStatus;
    }

    public void setMethodExecutionStatus(MethodExecutionStatus methodExecutionStatus) {
        this.methodExecutionStatus = methodExecutionStatus;
    }
}
