package org.imp.cloud.micoserviceconsumermovie.fallback;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HystrixCommandExample {
    @HystrixCommand(fallbackMethod = "defaultName")
    public String getName(String name) throws Exception{
        if("zhudi".equals(name)){
            return "name is :"+name;
        }else{
            throw new Exception();
        }
    }

    public String defaultName(String name){
        return "this name dost not exist";
    }
}
