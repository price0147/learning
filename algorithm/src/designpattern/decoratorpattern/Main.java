package designpattern.decoratorpattern;

import designpattern.decoratorpattern.components.Milk;
import designpattern.decoratorpattern.decorater.Honey;
import designpattern.decoratorpattern.decorater.Sugar;

/**
 * @author: wangxu
 * @date: 2020/4/16 16:40
 */
public class Main {
    public static void main(String[] args) {
        //测试装饰者模式
        //新建一个牛奶组件
        Drink milk = new Milk();
        //用糖去修饰他
        milk = new Sugar(milk);
        //用蜂蜜修饰糖加牛奶的组合组件(这其实也是一种功能的拓展)
        milk = new Honey(milk);

        System.out.println("价格:" + milk.cost() + " 名字:" + milk.getDrinkName());
    }
}
