package client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@FeignClient(name = "client", fallback = ErrorAPI.class )
public interface APIRestController {

    @GetMapping(value = "/hi")
    String hi();
}
