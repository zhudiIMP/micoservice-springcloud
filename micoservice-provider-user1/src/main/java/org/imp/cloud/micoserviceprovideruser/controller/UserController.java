package org.imp.cloud.micoserviceprovideruser.controller;

import org.imp.cloud.micoserviceprovideruser.entity.User;
import org.imp.cloud.micoserviceprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        User user1 = new User() ;
        user1.setAge(12);
        user1.setBalance(new BigDecimal(12));
        user1.setName("wang");
        return user1;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

}
