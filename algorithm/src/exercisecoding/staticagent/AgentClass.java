package exercisecoding.staticagent;

/**
 * @author: wangxu
 * @date: 2020/9/16 14:35
 */
public class AgentClass implements StaticAgentInter{
    StaticAgentInter staticAgentInter;
    //唯一的构造器.想new一个代理类对象就必须初始化一个代理类
    public AgentClass(StaticAgentInter staticAgentInter){
        this.staticAgentInter = staticAgentInter;
    }
    //代理部分.
    @Override
    public void soutLog() {
        before();
        staticAgentInter.soutLog();
    }

    private void before(){
        System.out.println("我是增强类");
    }
}
