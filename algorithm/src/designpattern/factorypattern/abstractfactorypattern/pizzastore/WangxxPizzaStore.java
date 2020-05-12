package designpattern.factorypattern.abstractfactorypattern.pizzastore;

import designpattern.factorypattern.abstractfactorypattern.ingredientfactory.NYPizzaIngredientFactory;
import designpattern.factorypattern.abstractfactorypattern.ingredientfactory.PizzaIngredientFactory;
import designpattern.factorypattern.abstractfactorypattern.pizza.AbstractFactoryPizza;
import designpattern.factorypattern.abstractfactorypattern.pizza.AbstractWangxPizza;
import designpattern.factorypattern.abstractfactorypattern.pizza.AbstractWangxxPizza;

/**
 * @author: wangxu
 * @date: 2020/5/12 10:34
 */
public class WangxxPizzaStore extends FactoryMethodPizzaStore {
    //重写工厂方法里的类(这里使用的还是工厂方法模式)
    //这里只涉及了一个披萨
    @Override
    public AbstractFactoryPizza CreatePizza(String type) {
        AbstractFactoryPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("AbstractWangxPizza")) {
            pizza = new AbstractWangxPizza(ingredientFactory);
            pizza.setName("王旭的抽象工厂Pizza");
        }else{
            pizza = new AbstractWangxxPizza(ingredientFactory);
            pizza.setName("王旭的抽象工厂Pizza(一)");
        }
        return pizza;
    }
}
