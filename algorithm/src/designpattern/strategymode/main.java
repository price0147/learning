package designpattern.strategymode;

import designpattern.strategymode.Impl.NeedleArmsImpl;
import designpattern.strategymode.character.XiaoFei;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:58
 */
public class main {
    public static void main(String[] args) {
        XiaoFei xiaoFei = new XiaoFei();
        System.out.println(xiaoFei.name + xiaoFei.useArms() + xiaoFei.walk() + xiaoFei.useAction());
        //动态定义武器类
        xiaoFei.setArms(new NeedleArmsImpl());
        //再次输出:这个位置看一下,我的调用方式完全没有变,只是复制粘贴了.
        System.out.println(xiaoFei.name + xiaoFei.useArms() + xiaoFei.walk() + xiaoFei.useAction());
    }

}
