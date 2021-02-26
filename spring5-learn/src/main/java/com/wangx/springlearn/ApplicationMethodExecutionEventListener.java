package com.wangx.springlearn;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听接口实现类
 * @author: wangxu
 * @date: 2021-02-13 12:56
 */
@Component
public class ApplicationMethodExecutionEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ApplicationMethodExecutionEvent){
            System.out.println("我已经正确的监听到了这个事件");
        }
    }
}
