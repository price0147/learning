package com.wangx.springlearn;

import java.util.EventListener;

/**
 * 监听接口实现类
 * @author: wangxu
 * @date: 2021-02-13 12:56
 */
public interface MethodExecutionEventListener extends EventListener {
    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     */
    void onMethodBegin(MethodExecutionEvent evt);

    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     * @param evt
     */
    void onMethodEnd(MethodExecutionEvent evt);
}
