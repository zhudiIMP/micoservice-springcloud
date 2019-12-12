package org.imp.cloud.micoserviceproviderapi.api;


import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.imp.cloud.micoserviceproviderapi.fallback.ProviderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-provider-user",fallback = ProviderServiceFallback.class)
public interface ProviderService {
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") int id);
}
