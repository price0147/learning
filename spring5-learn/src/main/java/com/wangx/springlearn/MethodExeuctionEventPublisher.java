package com.wangx.springlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件发布者
 * @author: wangxu
 * @date: 2021-02-13 13:06
 */
public class MethodExeuctionEventPublisher {
    private List<MethodExecutionEventListener> listeners = new ArrayList<>();

    public void methodToMonitor(){
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this, "methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN, event2Publish);
        publishEvent(MethodExecutionStatus.END,event2Publish);
    }

    protected void publishEvent(MethodExecutionStatus status,MethodExecutionEvent methodExecutionEvent){
        List<MethodExecutionEventListener> copyListeners = new ArrayList<>(listeners);
        for (MethodExecutionEventListener listener : copyListeners) {
            if (MethodExecutionStatus.BEGIN.equals(status)) {
                listener.onMethodBegin(methodExecutionEvent);
            }else{
                listener.onMethodEnd(methodExecutionEvent);
            }
        }
    }

    public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener)
    {
        if(this.listeners.contains(listener)){
            this.listeners.remove(listener);
        }
    }

    public void removeAllListeners()
    {
        this.listeners.clear();
    }


}
