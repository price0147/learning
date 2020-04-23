package designpattern.decoratorpattern.decorater;

import designpattern.decoratorpattern.Drink;

/**
 * @author: wangxu
 * @date: 2020/4/16 16:37
 */
public class Honey implements Drink {
    Drink drink;

    public Honey(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String getDrinkName() {
        return drink.getDrinkName() + " + 蜂蜜";
    }

    @Override
    public double cost() {
        return drink.cost() + 6.6;
    }
}
