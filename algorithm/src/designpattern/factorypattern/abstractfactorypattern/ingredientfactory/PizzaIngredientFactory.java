package designpattern.factorypattern.abstractfactorypattern.ingredientfactory;

import designpattern.factorypattern.ingredienclass.*;

/**
 * 披萨酱料接口
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Pepperoni createPepperoni();
    public Clams createClams();
}
