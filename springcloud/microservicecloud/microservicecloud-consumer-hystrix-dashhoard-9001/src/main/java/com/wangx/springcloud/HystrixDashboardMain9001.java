package com.wangx.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: wangxu
 * @date: 2020/5/19 21:03
 */
@SpringBootApplication
@Slf4j
//开启Hystrix的仪表盘图形化界面
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
        log.info(">>>>>>启动完成<<<<<<<");
    }

}
