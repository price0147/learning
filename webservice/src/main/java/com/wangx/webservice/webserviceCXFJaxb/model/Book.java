package com.wangx.webservice.webserviceCXFJaxb.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: wangxu
 * @date: 2020/2/3 16:08
 */
@XmlRootElement
public class Book {
    private String bookName;
    private double price;
    private String id;

    public Book() {
    }

    public Book(String bookName, double price, String id) {
        this.bookName = bookName;
        this.price = price;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }
}
