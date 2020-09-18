package exercisecoding.StaticAgent;

/**
 * @author: wangxu
 * @date: 2020/9/16 14:35
 */
public class AgentClass implements StaticAgentInter{
    StaticAgentInter staticAgentInter;
    public AgentClass(StaticAgent staticAgentInter){
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
