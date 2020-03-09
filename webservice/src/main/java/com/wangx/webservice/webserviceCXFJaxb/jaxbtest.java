package com.wangx.webservice.webserviceCXFJaxb;


import com.wangx.webservice.webserviceCXFJaxb.model.Book;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @author: wangxu
 * @date: 2020/2/3 16:10
 */

public class jaxbtest {
    @Test
    public void myMarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.marshal(new Book("王旭的数", 1.8d, "22L"), System.out);
    }

    @Test
    public void myUnmarshaller() throws JAXBException {
        String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><book><bookName>王旭的数</bookName><id>22L</id><price>1.8</price></book>";
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Book book = (Book) unmarshaller.unmarshal(new StringReader(xmlString));
        System.out.println(book.toString());

    }

}
