package designpattern.strategymode.Impl;

import designpattern.strategymode.inter.Action;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:40
 */
public class JumpActionImpl implements Action {
    @Override
    public String action() {
        return "跳起来就是一刀";
    }
}
