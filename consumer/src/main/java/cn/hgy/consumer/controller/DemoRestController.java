package cn.hgy.consumer.controller;

import cn.hgy.consumer.api.ProviderAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@RestController
public class DemoRestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProviderAPI providerAPI;

    @GetMapping("/invoke/{text}")
    public String invoke(@PathVariable(value = "text") String text) {
        return restTemplate.getForObject("http://provider/hi/" + text, String.class);
    }

    @GetMapping("/invoke/remote")
    public String invoke2() {
        return providerAPI.hi();
    }
}
