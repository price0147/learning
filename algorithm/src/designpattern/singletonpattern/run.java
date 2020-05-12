package designpattern.singletonpattern;

/**
 * @author: wangxu
 * @date: 2020/5/12 14:13
 */
public class run {
    public static void main(String[] args) {
        System.out.println(Singleton.getSingleton());
        System.out.println(Singleton.getSingleton());
    }
}
