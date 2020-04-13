package designpattern.observerpattern.inter;

/**
 * @author: wangxu
 * @date: 2020/4/13 16:07
 *
 * 这是一个主题的接口,所有主题都要实现这个类:
 * 注:观察者模式中java也有提供,只不过提供是一个类.而不是接口
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
