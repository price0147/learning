package com.wangx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangxu
 * @date: 2020/5/29 11:06
 * 这个配置类是展示以编码方式配置路由器的
 */
@Configuration
public class  GatewayConfig {
    //RouteLocator这是一个路由对象
    //RouteLocatorBuilder路由构建器

    /**
     * 配置一个id为path_route_wangx的路由规则
     * 当访问地址http://localhost:9527/guonei时会自动转发到地址:http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //routes对象就相当于配置文件中的routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //相当于配置文件中
        /**
         * cloud:
         *     gateway:
         *       routes:
         *           id: payment_routh
         * http://news.baidu.com/guonei
         */
        routes.route("path_route_wangx",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
