package designpattern.factorypattern;

import designpattern.factorypattern.abstractfactorypattern.pizzastore.WangxxPizzaStore;
import designpattern.factorypattern.factorymethodpattern.FactoryMethodPizzaStore;
import designpattern.factorypattern.factorymethodpattern.WangxPizzaStore;

/**
 * @author: wangxu
 * @date: 2020/5/8 11:11
 */
public class run {
    public static void main(String[] args) {
        //简单工厂测试
        /*PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        pizzaStore.orderPizza("wangxx");*/

        //工厂方法测试
        //FactoryMethodPizzaStore pizzaStore = new WangxPizzaStore();
        //pizzaStore.orderPizza("wangxx");

        //抽象工厂测试
        WangxxPizzaStore pizzaStore = new WangxxPizzaStore();
        pizzaStore.orderPizza("AbstractWangxxPizza");
    }
}
