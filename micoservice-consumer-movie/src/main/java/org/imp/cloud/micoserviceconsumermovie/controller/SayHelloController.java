package org.imp.cloud.micoserviceconsumermovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SayHelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){
        return restTemplate.getForEntity("http://MICROSERVICE-PROVIDER-USER/sayHello",String.class).getBody();
    }
}
