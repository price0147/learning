# Eureka
Eureka包括两个组件:Eureka Service 和 Eureka Client

Eureka Service 提供服务注册服务:<br/>
各个微服务节点通过配置启动后,会在Eureka Service中注册,这样EurekaService中的服务注册表中将会存储所有可用节点的信息,服务节点的信息可以在界面直观的看到.

Eureka Client 通过注册中心进行访问:<br/>
是一个java客户端,用于简化Eureka Ser
vice的交互,客户端同时也具备一个内置的,使用轮询负载算法的负载均衡器.在应用启动后,将会将Eureka Service发送心跳机制(默认周期是30秒).如果Eureka Service在多个心跳周期内没有收到某个节点心跳,Eureka Service将会从服务注册表中把这个服务节点移除(默认90秒)

# 集群Eureka搭建步骤
![](.Note_images/36edb623.png)
## 集群注册原理
    相互注册,相互守望
        :就是互相调用(A调用B,B也可以调用A)