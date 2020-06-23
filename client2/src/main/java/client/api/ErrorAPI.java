package client.api;

import org.springframework.stereotype.Component;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@Component
public class ErrorAPI implements  APIRestController{
    @Override
    public String hi() {
        return "error";
    }
}
