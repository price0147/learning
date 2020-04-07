package designpattern.strategymode.Impl;

import designpattern.strategymode.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 10:56
 */
public class NeedleArmsImpl implements Arms {
    @Override
    public String arms() {
        return "拿着一把针";
    }
}
