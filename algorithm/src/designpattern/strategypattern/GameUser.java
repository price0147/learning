package designpattern.strategypattern;

import designpattern.strategypattern.inter.Action;
import designpattern.strategypattern.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:32
 */

/**
 * 这是一个(超类)抽象类,假设所有游戏人物都可以行走和奔跑
 */
public abstract class GameUser {
    //注意他的权限修饰符
    /**
     * 多用组合少用继承:
     *  将武器和动作接口提出来并组合到超类中.
     * 为什么要将这两个接口提出来?(答案:提升系统弹性,增强可拓展性  设计原则:把容易变化的东西提出来封装)
     *  因为以后会有很多人物也会有很多动作.
     *      这个超类的作用就是把人物的一些基础信息和基础动作都放到这里面.(然后针对这超类进行编程和扩展)
     *  为什么不吧,这样两个接口直接定义在这个超类里面
     *      答案:这样造成代码复用性问题,如果两个人物有同一套武器和动作,那么在人物子类继承这个超类是,
     *      他就必须将两个实现的接口写成一样的,这样以后重复的代码就会越来越多,一担需要修改,这些一样的接口实现,
     *      都需要被修改.这样不好维护,也不好代码复用
     */
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
