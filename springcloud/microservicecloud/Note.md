# CAP理论
C - consistency 强一致性<br>
A - availability  可用性<br>
P - partition tolerance 分区容错性<br>
CA - 单点集群，满足一致性，可用性，通常在可拓展性上不太强大<br>
CP - 满足一致性，分区容错性的系统，通常性能不是特别的高<br>
AP - 满足可用性，分区容错性，通过对数据一致性要求低一些。<br>
# Eureka(AP特性)
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
    这一部分需要修改映射配置
    修改本地Host文件添加内容:127.0.0.1    eureka7001.com
                           127.0.0.1    eureka7002.com
                           127.0.0.1    eureka7003.com
    修改原因:我们要用到集群,但是物理上我们只有一台机器所有我们要配置这个映射
    ,用不同的端口号来映射同一个地址
## actuator微服务信息完善
完善一些细节问题.
### 主机名称:服务名称修改
```yaml
eureka:
  client:
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓住已有的注册信息,默认为true.单节点无所谓,集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
#      defaultZone : http://localhost:7001/eureka  ->以前的单机版
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    instance-id: payment8002 #设置你的主机名称
```
### 设置IP提示
```yaml
eureka:
  client:
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓住已有的注册信息,默认为true.单节点无所谓,集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
#      defaultZone : http://localhost:7001/eureka  ->以前的单机版
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    instance-id: payment8001
    prefer-ip-address: true #访问路径可以显示ip地址
```
## 服务发现Discovery
对于注册进eureka里面的微服务,可以通过服务发现来获得该服务的消息

### DiscoveryClient对象
```java
    //DiscoveryClient这是一个服务发现的对象,发现一些自己的基础信息比如:端口号,服务名
    @Resource
    private DiscoveryClient discoveryClient;
```
### @EnableDiscoveryClient
主启动类上添加注解开启服务发现功能
```java
@SpringBootApplication
@Slf4j
@EnableEurekaClient
//用于服务发现
@EnableDiscoveryClient
public class PaymentMain8001 {
```
### 代码实现获取服务信息
```java
@GetMapping(value = "/discovery")
public Object discovery(){
    //获取服务清单列表(方式一)
    List<String> service = discoveryClient.getServices();
    service.forEach(x -> log.info("********" + x));

    //通过服务名获取对应服务名下的Instance实例
    List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-PAYMENT-SERVICE");
    instances.forEach(x -> log.info(x.getServiceId() + "\t" + x.getHost() + "\t" + x.getInstanceId() + "\t" + x.getPort() + "\t" + x.getUri()));
    return discoveryClient;
}
```
## Eureka自我保护
概述:<br>
保护模式主要用于一组客户端和Eureka Service之间存在网络分区场景下的保护.
一旦进入保护模式,Eureka Service将会尝试保护其服务注册中心的信息,不再删除
服务注册表中的数据,也就是不会注销任何服务.


为什么会产生Eureka自我保护机制?<br>
为了防止EurekaClient可能正常运行,但是与EurekaService网络不通情况下,EurekaService不会立刻将EurekaClient服务剔除

什么是自我保护模式?<br>
默认情况下,如果EurekaService在一定时间内没有接收到某个微服务实例的心跳,EurekaService将会注销该实例(默认90秒),但是
当网络分区故障发生(延时,卡顿,拥挤)时,微服务与EurekaService之间无法正常通信,以上行为可能变得非常危险了——因为微服务本身
其实是健康的,此时本不应该注销这个服务.Eureka通过"自我保护模式"来解决这个问题——当Eureka节点在短时间内丢失过多客户端时(可能发生网络分区故障),那么这个节点就会进入自我保护机制

在自我保护模式中,Eureka Server会保护服务注册表中的信息,不再注销任何服务实例<br>
它的设计哲学就是宁可保留错误的服务注册信息,也不盲目注销任何可能健康的服务实例.
### 服务端关闭自我保护机制
```yaml
eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    #false表示不向注册中心注册自己
    register-with-eureka: false
    #false表示自己端就是注册中心,我的职责就是维护服务器实例,并不需要去检索服务
    fetch-registry: false
    service-url:
      #设置与Eureka Server 交互的地址查询服务和注册服务都需要依赖这个地址
      #通俗易懂的说就是将自己注册到下面这个eureka上去
      #相互守望,相互注册,如果想实现集群高可用,有多台服务器,可以用逗号隔开
      #如果是单机版下面直接写直接的地址就行了
      #defaultZone: http://eureka7002:7002/eureka/ #集群模式->指向其他注册中心
      defaultZone: http://eureka7001:7001/eureka/ #单机模式->指向自己
  server:
    enable-self-preservation: false #关闭自我保护机制
    eviction-interval-timer-in-ms: 2000 #设置默认时间(单位ms)
```
### 客户端修改心跳时间
```yaml
eureka:
  client:
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓住已有的注册信息,默认为true.单节点无所谓,集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
#      defaultZone : http://localhost:7001/eureka  ->以前的单机版
      #集群版
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    instance-id: payment8001
    prefer-ip-address: true #访问路径可以显示ip地址
    #Eureka客户端向服务端发送心跳时间间隔,单位为秒(默认为30秒)
    lease-renewal-interval-in-seconds: 1
    #Eureka客户端在收到最后一次心跳后等待时间上限,单位为秒(默认为90秒),超时剔除服务
    lease-expiration-duration-in-seconds: 2
```
# zookeeper替换Eureka整合springCloud(CP特性)
zookeeper节点区分<br>
1.临时节点<br>
2.带序号的临时节点<br>
3.持久节点<br>
4.带序号的持久节点<br>

注意:微服务注册到zookeeper中时是属于临时节点,也就是说它不会像Eureka一样会有自我保护机制,只要某一节点在心跳过程中中断zookeeper就会将该节点剔除.

# Consul
## 能做呢什么
1. 服务注册与发现 -> 提供HTTP和DNS两种发现方式
2. 健康检查 -> 支持多种方式,HTTP,TCP,Docker,Shell脚本定制化
3. KV存储 -> Key、Value的存储方式
4. 多数据中心 -> Consul支持多数据中心
5. 可视化Web界

## 注册与发现
中文教程:https://www.springcloud.cc/spring-cloud-consul.html <br>
基本步骤和zookeeper是一样的
1. 安装Consul
2. pom引包
3. 配置文件,配置地址.
4. 主启动类添加@EnableDiscoveryClient
# 三个注册中心的异同
![](.Note_images/e322df98.png)