package exercisecoding.dynamicagent.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: wangxu
 * @date: 2020/9/16 14:35
 */
public class AgentClass implements InvocationHandler {
    JdkDynamicAgentInter jdkDynamicAgentInter;
    public AgentClass(JdkDynamicAgentInter jdkDynamicAgentInter){
        this.jdkDynamicAgentInter = jdkDynamicAgentInter;
    }

    private void before(){
        System.out.println("我是增强类");
    }

    //代理部分.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //调用invoke方法来替代静态代理里面的方法调用
        return method.invoke(jdkDynamicAgentInter, args);
    }
}
