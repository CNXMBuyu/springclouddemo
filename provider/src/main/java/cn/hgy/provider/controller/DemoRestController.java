package cn.hgy.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoyu.huang
 * @version 1.0.0
 */
@RestController
public class DemoRestController {

    @Autowired
    private Environment environment;

    @GetMapping("/hi2/{text}")
    public String hi(@PathVariable(name = "text") String text){
        return "hello, " + text;
    }

    @GetMapping("/hi/remote")
    public String hiRemote(){
        return "hello, " + environment.getProperty("user.name");
    }
}
