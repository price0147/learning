package designpattern.factorypattern.simplefactorypattern;


import designpattern.factorypattern.pizzasubclass.Pizza;
import designpattern.factorypattern.pizzasubclass.WangxPizza;
import designpattern.factorypattern.pizzasubclass.WangxxPizza;

/**
 * @author: wangxu
 * @date: 2020/5/8 10:00
 * 工厂方法
 */
public class SimplePizzaFactory {
    public Pizza CreatePizza(String type){
        Pizza pizza = null;
        if (type.equals("wangx")) {
            return new WangxPizza();
        }else{
            return new WangxxPizza();
        }
    }
}
