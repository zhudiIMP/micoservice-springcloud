package org.imp.cloud.micoserviceprovideruser.controller;

import org.imp.cloud.micoserviceprovideruser.entity.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
public class UserController {

    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id) {
        User user1 = new User() ;
        user1.setAge(12);
        user1.setBalance(new BigDecimal(12));
        user1.setName("zhang");
        return user1;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

}
