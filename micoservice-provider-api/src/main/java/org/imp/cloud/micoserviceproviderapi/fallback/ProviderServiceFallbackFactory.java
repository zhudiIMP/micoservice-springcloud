package org.imp.cloud.micoserviceproviderapi.fallback;

import feign.hystrix.FallbackFactory;
import org.imp.cloud.micoserviceproviderapi.api.ProviderService;
import org.imp.cloud.micoserviceproviderapi.dto.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProviderServiceFallbackFactory implements FallbackFactory<ProviderService>{
    @Override
    public ProviderService create(Throwable cause) {
        return new ProviderService() {
            @Override
            public User findById(int id){
                User user = new User() ;
                user.setId(id);
                user.setUsername("fallback");
                user.setAge(id);
                user.setBalance(new BigDecimal(id));
                user.setName("fallback");
                return user;
            }
        };
    }
}
