package designpattern.decoratorpattern.components;

import designpattern.decoratorpattern.Drink;
import sun.plugin2.message.GetAppletMessage;

/**
 * @author: wangxu
 * @date: 2020/4/16 14:04
 */
public class Milk implements Drink {

    @Override
    public String getDrinkName() {
        return "牛奶";
    }

    @Override
    public double cost() {
        return 3.5;
    }
}
