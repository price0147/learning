package designpattern.factorypattern.factorymethodpattern;

import designpattern.factorypattern.pizzasubclass.Pizza;
import designpattern.factorypattern.pizzasubclass.WangxPizza;
import designpattern.factorypattern.pizzasubclass.WangxxPizza;


/**
 * @author: wangxu
 * @date: 2020/5/8 11:52
 */
public class WangxPizzaStore extends FactoryMethodPizzaStore{
    @Override
    public Pizza CreatePizza(String type) {
        if (type.equals("wangx")) {
            return new WangxPizza();
        }else{
            return new WangxxPizza();
        }
    }
}
