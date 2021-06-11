package org.imp.cloud.micoserviceprovideruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"org.imp.cloud"})
@MapperScan(basePackages={"org.imp.cloud.micoserviceprovideruser.mapper*"})
public class MicoServiceProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicoServiceProviderUserApplication.class, args);
    }
}
