package designpattern.singletonpattern;

/**
 * @author: wangxu
 * @date: 2020/5/12 13:58
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton(){
        System.out.println("我是一个单利对象");
    }

    public static Singleton getSingleton(){
        if(singleton == null){
            singleton = new Singleton();
            return singleton;
        }
        return singleton;
    }
}
