package designpattern.factorypattern.pizzasubclass;

import java.util.ArrayList;

/**
 * @author: wangxu
 * @date: 2020/5/8 10:06
 * Pizza抽象类
 */
public abstract class Pizza {
    //披萨名字
    protected String name;
    //面团
    protected String dough;
    //酱
    protected String sauce;
    //新加工序
    protected ArrayList toppings = new ArrayList();

    public void prepare(){
        System.out.println("披萨名字: " + name);
        System.out.println("揉面");
        System.out.println("加酱");
        System.out.println("添加工序: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("" + toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("烤20分钟");
    }

    public void cut(){
        System.out.println("来TM一刀");
    }

    public void box(){
        System.out.println("弄个盒子");
    }

    public String getName(){
        return name;
    }
}
