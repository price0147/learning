package designpattern.statepattern.stateimpl;

import designpattern.statepattern.CandyMachine;
import designpattern.statepattern.State;

/**
 * @author: wangxu
 * @date: 2020/9/10 15:42
 */
public class NoMoneyState implements State {
    CandyMachine candyMachine;

    public NoMoneyState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void giveMoney() {

    }

    @Override
    public void pullRod() {

    }

    @Override
    public void refundMoney() {

    }

    @Override
    public void handedOut() {

    }

    @Override
    public void addSweets(int num) {

    }
}
