package cn.hgy.client.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@RestController
public class Client1RestController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "error")
    public String hi() {
        int i = new Random().nextInt(10);
        if(i % 2 == 0){
            throw new RuntimeException("");
        }else{
            return "hello, " + port;
        }
    }

    @GetMapping(value = "/run")

    public String run() {
        return restTemplate.getForObject("http://client/hi", String.class);
    }

    public String error(){
        return "error"+ port;
    }
}
