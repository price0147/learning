package designpattern.factorypattern.abstractfactorypattern.pizza;

import designpattern.factorypattern.abstractfactorypattern.ingredientfactory.PizzaIngredientFactory;

/**
 * @author: wangxu
 * @date: 2020/5/12 10:47
 */
public class AbstractWangxPizza extends AbstractFactoryPizza{
    //披萨材料工厂类
    PizzaIngredientFactory pizzaIngredientFactory;

    public AbstractWangxPizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    //通过材料工厂获取材料
    @Override
    public void prepare() {
        System.out.println("准备" + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
