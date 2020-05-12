package designpattern.factorypattern.abstractfactorypattern.ingredientfactory;

import designpattern.factorypattern.ingredienclass.*;

/**
 * @author: wangxu
 * @date: 2020/5/12 10:30
 * 具体的Pizza酱料工厂,可以通过PizzaIngredientFactory这个接口在Pizza类中动态获取酱料,降低耦合
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new Dough();
    }

    @Override
    public Sauce createSauce() {
        return new Sauce();
    }

    @Override
    public Cheese createCheese() {
        return new Cheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    @Override
    public Clams createClams() {
        return new Clams();
    }
}
