package net.nemo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tonyshi on 15/10/16.
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
