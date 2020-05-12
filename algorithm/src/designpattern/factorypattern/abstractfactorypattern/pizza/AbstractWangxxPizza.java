package designpattern.factorypattern.abstractfactorypattern.pizza;

import designpattern.factorypattern.abstractfactorypattern.ingredientfactory.PizzaIngredientFactory;

/**
 * @author: wangxu
 * @date: 2020/5/12 11:21
 */
public class AbstractWangxxPizza extends AbstractFactoryPizza{
    //披萨材料工厂类
    PizzaIngredientFactory pizzaIngredientFactory;

    public AbstractWangxxPizza(PizzaIngredientFactory pizzaIngredientFactory){
        toppings.add("我特么给你来一锤");
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    //通过材料工厂获取材料
    @Override
    public void prepare() {
        System.out.println("准备" + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        pepperoni = pizzaIngredientFactory.createPepperoni();
        clams = pizzaIngredientFactory.createClams();
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("" + toppings.get(i));
        }
    }
}
