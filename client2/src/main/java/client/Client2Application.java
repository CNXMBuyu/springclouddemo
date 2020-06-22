package client;

import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class Client2Application {

    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class);
    }


    @Bean
    public Retryer retryer(){
        // 默认构造函数效果如下，重试间隔100毫秒，最大重试时间1秒，重试次数5次
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}
