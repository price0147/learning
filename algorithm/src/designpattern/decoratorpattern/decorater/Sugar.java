package designpattern.decoratorpattern.decorater;

import designpattern.decoratorpattern.Drink;

/**
 * @author: wangxu
 * @date: 2020/4/16 16:18
 */
public class Sugar  implements Drink {
    //组件(利用组合)
    private Drink drink;

    public Sugar(Drink drink){
        this.drink = drink;
    }
    @Override
    public String getDrinkName() {
        return drink.getDrinkName() + " + 糖";
    }

    @Override
    public double cost() {
        return drink.cost() + 3.2;
    }
}
