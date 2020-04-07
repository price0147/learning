package designpattern.strategymode.character;

import designpattern.strategymode.GameUser;
import designpattern.strategymode.Impl.CattleArmsImpl;
import designpattern.strategymode.Impl.JumpActionImpl;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:48
 */
public class XiaoFei extends GameUser {
    public final String name = "小飞";

    public XiaoFei(){
        arms = new CattleArmsImpl();
        action = new JumpActionImpl();
    }
}
