package net.nemo.springmvc.model;

/**
 * Created by tonyshi on 15/10/16.
 */
public class User {
    private String name;
    private String age;

    public User(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
