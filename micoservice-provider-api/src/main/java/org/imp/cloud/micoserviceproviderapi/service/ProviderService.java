package org.imp.cloud.micoserviceproviderapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ProviderService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") String id);


}
