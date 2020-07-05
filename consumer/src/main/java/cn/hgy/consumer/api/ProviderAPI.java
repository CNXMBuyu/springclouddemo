package cn.hgy.consumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@FeignClient(name = "provider")
public interface ProviderAPI {

    @GetMapping("/hi/remote")
    String hi();
}
