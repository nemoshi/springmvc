package net.nemo.springmvc.controller;

import net.nemo.springmvc.model.User;
import net.nemo.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tonyshi on 15/10/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(){
        return "user/list";
    }

    @RequestMapping(value="/new/{id}/{name}/{age}", method=RequestMethod.POST)
    public String add(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("age") String age){
        if(userService.isExisted(id)){
            throw new IllegalArgumentException("User already existed");
        }
        else{
            userService.add(id, new User(name, age));
        }

        return "user/list";
    }
}
