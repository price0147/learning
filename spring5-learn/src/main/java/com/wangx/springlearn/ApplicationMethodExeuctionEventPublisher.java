package com.wangx.springlearn;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件发布者
 * @author: wangxu
 * @date: 2021-02-13 13:06
 */
@Component
public class ApplicationMethodExeuctionEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void methodToMonitor(){
        ApplicationMethodExecutionEvent beginEvt = new ApplicationMethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        this.applicationEventPublisher.publishEvent(beginEvt);
        System.out.println("这里面是处理这个方法的逻辑");
        ApplicationMethodExecutionEvent endEvt = new ApplicationMethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        this.applicationEventPublisher.publishEvent(endEvt);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

}
