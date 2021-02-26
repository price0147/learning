package com.wangx.springlearn;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * 事件监听接口
 * @author: wangxu
 * @date: 2021-02-13 13:03
 */
public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener{
    @Override
    public void onMethodBegin(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("方法开始" + methodName);
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("方法结束" + methodName);
    }
}
