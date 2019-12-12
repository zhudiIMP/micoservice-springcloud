package org.imp.cloud.micoserviceproviderapi.fallback;

import org.imp.cloud.micoserviceproviderapi.api.ProviderService;
import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProviderServiceFallback implements ProviderService {
    public User findById(int id){
        User user = new User() ;
        user.setId(id);
        user.setUsername("fallback");
        user.setAge(id);
        user.setBalance(new BigDecimal(id));
        user.setName("fallback");
        return user;
    }
}
