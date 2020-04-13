package designpattern.strategypattern.Impl;

import designpattern.strategypattern.inter.Action;

/**
 * @author: wangxu
 * @date: 2020/3/30 9:40
 * 这是一个动作接口的实现
 */
public class JumpActionImpl implements Action {
    @Override
    public String action() {
        return "跳起来就是一刀";
    }
}
