package designpattern.strategypattern.character;

import designpattern.strategypattern.GameUser;
import designpattern.strategypattern.Impl.CattleArmsImpl;
import designpattern.strategypattern.Impl.JumpActionImpl;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:48
 *  这是一个任务类
 */
public class XiaoFei extends GameUser {
    public final String name = "小飞";

    public XiaoFei(){
        arms = new CattleArmsImpl();
        action = new JumpActionImpl();
    }
}
