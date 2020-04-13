package designpattern.observerpattern.observer;

import designpattern.observerpattern.inter.Display;
import designpattern.observerpattern.inter.Observer;
import designpattern.observerpattern.inter.Subject;
import designpattern.observerpattern.module.News;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author: wangxu
 * @date: 2020/4/13 16:55
 */
public class TwoObserver implements Observer, Display {
    private String makeUpInfo;
    //主题对象
    private Subject news;

    public TwoObserver(Subject news){
        this.news = news;
        news.registerObserver(this);
    }

    //通过推的模式给的更新内容.
    @Override
    public void update(News news) {
        DateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
        makeUpInfo = "观察者二最新内容如下-> -> 标题: " + news.getTitle() + "  内容: 【观察者二不需要内容】  时间: " + sdf.format(news.getDate());
        show();
    }

    @Override
    public void show() {
        System.out.println(makeUpInfo);
    }
}
