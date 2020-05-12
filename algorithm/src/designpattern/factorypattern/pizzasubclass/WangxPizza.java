package designpattern.factorypattern.pizzasubclass;

/**
 * @author: wangxu
 * @date: 2020/5/8 10:09
 * pizza的子类
 */
public class WangxPizza extends Pizza {
    public WangxPizza(){
        name = "旭氏披萨";
        dough = "高筋面";
        sauce = "法式豆瓣酱";

        toppings.add("撒点麻油");
    }
}
