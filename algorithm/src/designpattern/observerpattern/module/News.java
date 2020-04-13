package designpattern.observerpattern.module;

import java.util.Date;

/**
 * @author: wangxu
 * @date: 2020/4/13 16:52
 */
public class News {
    //新闻内容
    private String info;
    //新闻事件
    private Date date = new Date();
    //新闻标题
    private String title;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "info='" + info + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                '}';
    }
}
