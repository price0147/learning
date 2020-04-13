package designpattern.observerpattern.theme;

import designpattern.observerpattern.inter.Observer;
import designpattern.observerpattern.inter.Subject;
import designpattern.observerpattern.module.News;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/4/13 16:15
 * 新闻主题(被观察者)
 */
public class NewsTheme implements Subject {
    //观察者集合
    private List<Observer> observerList;

    private News news;

    public void setNews(News news) {
        this.news = news;
    }

    /**
     * 对象被创建时,同时创建观察者列表(容器)
     */
    public NewsTheme() {
        //观察列表
        observerList = new ArrayList<>();
    }

    /**
     * 注册观察者
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除观察
     */
    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        observerList.remove(i);
    }

    /**
     * 新消息通知
     */
    @Override
    public void notifyObserver() {
        observerList.stream().forEach(x -> x.update(news));
    }
}
