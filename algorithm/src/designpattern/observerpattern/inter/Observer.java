package designpattern.observerpattern.inter;

import designpattern.observerpattern.module.News;

/**
 * @author: wangxu
 * @date: 2020/4/13 16:07
 *
 *  这个接口是更新数据的用的.所有观察者都要实现这个接口(典型的面向接口编程)
 *  这个位置需要注意的是:
 *      1.我们假设观察的对象是一个新闻对象.所以这里面的参数是New.
 *      2.对于这个方法我们采取的是推的模式,推送新消息.(就是主题更新后的内容全都发给你,无论你需不需要;
 *      对应的我们有一个拉的模式---每一个观察者会在你更新以后的对象中,自己获取所需变量)
 */
public interface Observer {
    //推模式
    public void update(News news);
}
