package com.codegym.model.repositories;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositories {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        users.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u2.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        users.add(u3);
    }

    public static User checklogin(Login login){
        for(User user : users){
            if(user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
