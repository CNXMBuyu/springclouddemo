# 模块介绍

- server1 : 主要的eureka server，端口8761
- server2 : eureka server集群，端口8762
- client1 : eureka client，即是服务调用者，也是服务提供者，通过ribbon-RestTemplate来调用
- client2 : eureka client，即是服务调用者，也是服务提供者，通过feign来调用

> 服务提供者需要通过spring.application.name=client和eureka.instance.preferIpAddress=true暴露自己的服务信息