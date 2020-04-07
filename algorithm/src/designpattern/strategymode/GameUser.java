package designpattern.strategymode;

import designpattern.strategymode.inter.Action;
import designpattern.strategymode.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:32
 */

/**
 * 这是一个(超类)抽象类,假设所有游戏人物都可以行走和奔跑
 */
public abstract class GameUser {
    //注意他的权限修饰符
    protected Arms arms;
    protected Action action;
    /**
     * 下面这两个方法的理念:因为Arms,Action.
     * 我不管谁实现了这个方法是怎么实现的,我只需要调用这个方法即可.
     * 实现留给他的具体实现类.
     * 好处就是让系统更有弹性,以后我加动作或者加武器的时候我不需要修改这一部分代码,我只需要新增一个实现类即可,(所以有很好的拓展性)
     */
    public String useArms(){
        return arms.arms();
    }
    public String useAction(){
        return action.action();
    }

    //这两个set可以动态的设置任务的武器和动作
    public void setArms(Arms arms) {
        this.arms = arms;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    //下面这两个类就是所有角色都有的功能能.
    public String walk(){
        return "走着,走着";
    }

    public String run(){
        return "跑着,跑着";
    }
}
