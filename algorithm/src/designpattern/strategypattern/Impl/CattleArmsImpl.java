package designpattern.strategypattern.Impl;

import designpattern.strategypattern.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:44
 * 这是一个武器接口的实现
 */
public class CattleArmsImpl implements Arms {
    @Override
    public String arms() {
        return "拿着一把牛刀";
    }
}
