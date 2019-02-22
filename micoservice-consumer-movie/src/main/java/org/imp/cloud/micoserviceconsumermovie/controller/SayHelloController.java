package org.imp.cloud.micoserviceconsumermovie.controller;

import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.imp.cloud.micoserviceproviderapi.api.ProviderService;

@RestController
public class SayHelloController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){
        return restTemplate.getForEntity("http://MICROSERVICE-PROVIDER-USER/sayHello",String.class).getBody();
    }

    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id){
        return providerService.findById(id);
    }
}
