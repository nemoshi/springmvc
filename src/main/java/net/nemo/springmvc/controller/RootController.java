package net.nemo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonyshi on 15/10/16.
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/json")
    public Map<String, String> json(){
        return new HashMap<String, String>(){{
           put("name", "Tony");
           put("age", "12");
        }};
    }

    @ResponseBody
    @RequestMapping("/exception")
    public void exception(){
        int a = 6/0;
    }
}
