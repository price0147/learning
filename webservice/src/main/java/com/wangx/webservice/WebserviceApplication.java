package com.wangx.webservice;

import com.wangx.webservice.webserviceCXFJaxws.PublishingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceApplication.class, args);

        //PublishingService publishingService = new PublishingService();
        //publishingService.giveService();
        //publishingService.giveServiceTwo();
    }

}
