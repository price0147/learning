package exercisecoding.dynamicagent.jdk;

/**
 * @author: wangxu
 * @date: 2020/9/16 14:33
 */
public class JdkDynamicAgent implements JdkDynamicAgentInter {
    @Override
    public void soutLog() {
        System.out.println("我是JDK动态代理");
    }
}
