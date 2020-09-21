package exercisecoding.dynamicagent.cglib;


import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: wangxu
 * @date: 2020/9/18 14:20
 */
public class Run {
    public static void main(String[] args) {
        //创建代理
        CglibDynamicAgent dynamicAgent = new CglibDynamicAgent();
        CglibDynamicAgent cglibDynamicAgent = (CglibDynamicAgent) Enhancer.create(dynamicAgent.getClass(),new AgentClass());
        cglibDynamicAgent.soutLog();
    }

}
