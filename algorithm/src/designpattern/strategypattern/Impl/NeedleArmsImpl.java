package designpattern.strategypattern.Impl;

import designpattern.strategypattern.inter.Arms;

/**
 * @author: wangxu
 * @date: 2020/3/30 10:56
 * 这是一个武器接口的实现
 */
public class NeedleArmsImpl implements Arms {
    @Override
    public String arms() {
        return "拿着一把针";
    }
}
