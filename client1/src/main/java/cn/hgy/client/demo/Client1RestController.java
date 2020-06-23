package cn.hgy.client.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String hi() {
        return "hello, " + port;
    }

    @GetMapping(value = "/run")
    @HystrixCommand(fallbackMethod = "error")
    public String run() {
        throw new RuntimeException("");
//        return restTemplate.getForObject("http://client/hi", String.class);
    }

    public String error(){
        return "error";
    }
}
