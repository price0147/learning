package designpattern.observerpattern;

import designpattern.observerpattern.module.News;
import designpattern.observerpattern.observer.FourObserver;
import designpattern.observerpattern.observer.OneObserver;
import designpattern.observerpattern.observer.ThreeObserver;
import designpattern.observerpattern.observer.TwoObserver;
import designpattern.observerpattern.theme.NewsTheme;

import java.util.Date;

/**
 * @author: wangxu
 * @date: 2020/4/13 17:07
 */
public class main {
    public static void main(String[] args) {
        News news = new News();
        news.setDate(new Date());
        news.setInfo("今天气温22.5度");
        news.setTitle("天气预报");




        NewsTheme newsTheme = new NewsTheme();
        //注册观察者
        OneObserver oneObserver = new OneObserver(newsTheme);
        TwoObserver twoObserver = new TwoObserver(newsTheme);
        ThreeObserver threeObserver = new ThreeObserver(newsTheme);
        FourObserver fourObserver = new FourObserver(newsTheme);
        //修改对象
        newsTheme.setNews(news);
        //通知观察者
        newsTheme.notifyObserver();
    }
}
