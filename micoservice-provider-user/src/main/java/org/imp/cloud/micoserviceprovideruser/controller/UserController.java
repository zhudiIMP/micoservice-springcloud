package org.imp.cloud.micoserviceprovideruser.controller;

import org.imp.cloud.micoserviceproviderapi.api.ProviderService;
import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
//@RequestMapping("/providerUser")
public class UserController implements ProviderService {

    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id) {
        User user1 = new User() ;
        user1.setAge(12);
        user1.setBalance(new BigDecimal(12));
        user1.setName("user");
        return user1;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

}
