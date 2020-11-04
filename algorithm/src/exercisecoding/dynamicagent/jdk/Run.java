package exercisecoding.dynamicagent.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: wangxu
 * @date: 2020/9/18 14:20
 */
public class Run {
    public static void main(String[] args) {
        JdkDynamicAgent jdkDynamicAgent = new JdkDynamicAgent();
        //创建代理
        JdkDynamicAgentInter jdkDynamicAgentInter = (JdkDynamicAgentInter) Proxy.newProxyInstance(jdkDynamicAgent.getClass().getClassLoader(),
                jdkDynamicAgent.getClass().getInterfaces(),
                new AgentClass(jdkDynamicAgent));
        jdkDynamicAgentInter.soutLog();

        /*
        更动态的使用动态代理
         */
        JdkDynamicAgentInter proxy = (JdkDynamicAgentInter)new GoodAgentClass(jdkDynamicAgent).getProxyInstance();
        proxy.soutLog();
    }

}
