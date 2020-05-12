package designpattern.factorypattern.simplefactorypattern;


import designpattern.factorypattern.pizzasubclass.Pizza;

/**
 * @author: wangxu
 * @date: 2020/5/7 15:07
 *
 * 这是一个披萨店类
 */
public class PizzaStore {
    //组合,将工厂对象组合进来
    SimplePizzaFactory factory;

    //设置构造器.标准使用组合的方法.
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    //制造pizza的方法.
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = factory.CreatePizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
