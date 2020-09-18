package designpattern.statepattern;

public interface State {
    //投入25分
    void giveMoney();
    //拉杆
    void pullRod();
    //退钱
    void refundMoney();
    //发送糖果
    void handedOut();

    void addSweets(int num);

}
