package designpattern.strategymode.Impl;

import designpattern.strategymode.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:44
 */
public class CattleArmsImpl implements Arms {
    @Override
    public String arms() {
        return "拿着一把牛刀";
    }
}
