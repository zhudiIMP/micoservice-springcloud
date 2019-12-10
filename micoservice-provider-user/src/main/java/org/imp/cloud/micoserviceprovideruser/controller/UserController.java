package org.imp.cloud.micoserviceprovideruser.controller;

import org.imp.cloud.micoserviceproviderapi.api.ProviderService;
import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
public class UserController implements ProviderService {

    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id) {
        User user = new User() ;
        user.setAge(12);
        user.setBalance(new BigDecimal(12));
        user.setName("user");
        int i = 1/0;
        return user;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

}
