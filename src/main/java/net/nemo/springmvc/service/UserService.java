package net.nemo.springmvc.service;

import net.nemo.springmvc.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonyshi on 15/10/16.
 */
@Component
public class UserService {

    private static Map<String, User> users = new HashMap<String, User>(){{
       put("1", new User("Tony", "31"));
       put("2", new User("VV", "33"));
       put("3", new User("Jerry", "4.5"));
    }};

    public void add(String id, User u){
        UserService.users.put(id, u);
    }

    public void delete(String id){
        UserService.users.remove(id);
    }

    public boolean isExisted(String id){
        return UserService.users.containsKey(id);
    }

}
