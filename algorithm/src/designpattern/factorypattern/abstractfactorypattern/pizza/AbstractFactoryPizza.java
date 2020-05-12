package designpattern.factorypattern.abstractfactorypattern.pizza;

import designpattern.factorypattern.ingredienclass.*;

import java.util.ArrayList;
/**
 * @author: wangxu
 * @date: 2020/5/8 10:06
 * 重写Pizza抽象类,pizza这个类我们已经抽象出来了.所以这个类是不需要动的
 */
public abstract class AbstractFactoryPizza {
    //披萨名字
    protected String name;
    //面团
    protected Dough dough;
    //酱
    protected Sauce sauce;
    //奶酪
    protected Cheese cheese;
    //意大利 辣味 香肠
    protected Pepperoni pepperoni;
    //蛤蜊
    protected Clams clams;
    //新加工序
    protected ArrayList toppings = new ArrayList();
    //改为抽象类
    public abstract void prepare();

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

    public void setName(String name) {
        this.name = name;
    }
}


