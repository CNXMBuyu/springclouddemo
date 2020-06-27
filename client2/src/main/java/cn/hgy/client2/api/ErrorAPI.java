package cn.hgy.client2.api;

import org.springframework.stereotype.Component;

/**
 * feign的异常处理类
 *
 * @author guoyu.huang
 * @version 1.0.0
 */
@Component
public class ErrorAPI implements APIRestController {
    @Override
    public String hi() {
        return "error";
    }
}
