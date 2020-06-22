package client.demo;

import client.api.APIRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
    private APIRestController apiRestController;


    @GetMapping(value = "/hi")
    public String hi() {
        return "hello, " + port;
    }

    @GetMapping(value = "/run")
    public String run() {
        return apiRestController.hi();
    }
}
