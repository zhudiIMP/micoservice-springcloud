//package org.imp.cloud.micoserviceprovideruser.fallback;
//
//import org.imp.cloud.micoserviceproviderapi.api.ProviderService;
//import org.imp.cloud.micoserviceproviderapi.dto.User;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//@Component
//public class ProviderServiceFallback implements ProviderService {
//    public User findById(Long id){
//        User user = new User() ;
//        user.setAge(12);
//        user.setBalance(new BigDecimal(12));
//        user.setName("fallback");
//        return user;
//    }
//}