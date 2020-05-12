package designpattern.factorypattern.pizzasubclass;

/**
 * @author: wangxu
 * @date: 2020/5/8 10:10
 * pizza子类
 */
public class WangxxPizza extends Pizza {

    public  WangxxPizza(){
        name = "旭氏二号披萨";
        dough = "散面";
        sauce = "美式蒜蓉辣酱";

        toppings.add("撒点辣椒面");
    }

    public void cut(){
        System.out.println("给他来一锤");
    }
}
