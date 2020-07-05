package provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@RestController
public class DemoRestController {

    @GetMapping("/hi/{text}")
    public String hi(@PathVariable(name = "text") String text){
        return "hello, " + text;
    }
}
