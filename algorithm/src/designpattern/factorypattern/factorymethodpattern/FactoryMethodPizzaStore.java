package designpattern.factorypattern.factorymethodpattern;

import designpattern.factorypattern.pizzasubclass.Pizza;

/**
 * @author: wangxu
 * @date: 2020/5/7 15:07
 *
 * 这是一个披萨店类
 */
public abstract class FactoryMethodPizzaStore {

    //制造pizza的方法.
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = CreatePizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    //抽象的工厂方法.
    /**
     * 和简单工厂的区别在于解耦,
     * 简单工程:我获取Pizza对象时,要依赖于工厂SimplePizzaFactory类,
     * 而现在我们获取Pizza对象是由子类决定的,从而实现解耦.(面向超类编程的思想)————本类就是超类
     */
    public abstract Pizza CreatePizza(String type);
}
