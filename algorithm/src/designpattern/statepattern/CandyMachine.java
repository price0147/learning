package designpattern.statepattern;

import designpattern.statepattern.stateimpl.HaveMoneyState;
import designpattern.statepattern.stateimpl.NoMoneyState;
import designpattern.statepattern.stateimpl.SoldOutSweets;
import designpattern.statepattern.stateimpl.UnsoldSweets;

/**
 * @author: wangxu
 * @date: 2020/9/10 15:48
 */
public class CandyMachine {
    /*
    糖果机的状态:这些状态都是对于糖果机来说
     */
    //有25分的时候
    HaveMoneyState haveMoneyState;
    //没有25分的时候
    NoMoneyState noMoneyState;
    //售空的时候
    SoldOutSweets soldOutSweets;
    //售出糖果
    UnsoldSweets unsoldSweets;
    //状态接口
    State state;
    //记录糖果刷数量
    int countNum = 0;

    public CandyMachine(int countNum) {
        haveMoneyState = new HaveMoneyState(this);
        noMoneyState = new NoMoneyState(this);
        soldOutSweets = new SoldOutSweets(this);
        unsoldSweets = new UnsoldSweets(this);
        this.countNum = countNum;
        if (countNum > 0) {
            state = noMoneyState;
        }else{
            state = soldOutSweets;
        }
    }
    public void giveMoney(){
        state.giveMoney();
    }
    public void refundMoney(){
        state.refundMoney();
    }
    public void pullRod(){
        state.pullRod();
        //发放糖果是糖果机的内部方法，不允许用户调用
        state.handedOut();
    }

    public HaveMoneyState getHaveMoneyState() {
        return haveMoneyState;
    }

    public void setHaveMoneyState(HaveMoneyState haveMoneyState) {
        this.haveMoneyState = haveMoneyState;
    }

    public NoMoneyState getNoMoneyState() {
        return noMoneyState;
    }

    public void setNoMoneyState(NoMoneyState noMoneyState) {
        this.noMoneyState = noMoneyState;
    }

    public SoldOutSweets getSoldOutSweets() {
        return soldOutSweets;
    }

    public void setSoldOutSweets(SoldOutSweets soldOutSweets) {
        this.soldOutSweets = soldOutSweets;
    }

    public UnsoldSweets getUnsoldSweets() {
        return unsoldSweets;
    }

    public void setUnsoldSweets(UnsoldSweets unsoldSweets) {
        this.unsoldSweets = unsoldSweets;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }
}
