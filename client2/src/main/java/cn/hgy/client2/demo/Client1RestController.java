package cn.hgy.client2.demo;

import cn.hgy.client2.api.APIRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@RestController
public class Client1RestController {

    @Value("${server.port}")
    private String port;

    @Value("${key}")
    private String key;

    @Autowired
    private APIRestController apiRestController;

    @GetMapping(value = "/hi")
    public String hi() {
        int i = new Random().nextInt(10);
        if(i % 2 == 0){
            throw new RuntimeException("");
        }else{
            return "hello, " + port + " & remote_config" + key;
        }
    }

    @GetMapping(value = "/run")
    public String run() {
        return apiRestController.hi();
    }
}
