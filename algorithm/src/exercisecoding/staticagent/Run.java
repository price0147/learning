package exercisecoding.staticagent;

/**
 * @author: wangxu
 * @date: 2020/9/18 14:20
 */
public class Run {
    public static void main(String[] args) {

        //创建代理对象
        StaticAgentInter proxy = new AgentClass(new StaticAgent());
        proxy.soutLog();
    }
}
