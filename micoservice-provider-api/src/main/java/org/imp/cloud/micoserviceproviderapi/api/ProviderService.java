package org.imp.cloud.micoserviceproviderapi.api;

import org.imp.cloud.micoserviceproviderapi.dto.Response;
import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-provider-user")
public interface ProviderService {
    @RequestMapping(value = "/fallback/{id}",method = RequestMethod.GET)
    Response<User> findById(@PathVariable("id") int id);
}
