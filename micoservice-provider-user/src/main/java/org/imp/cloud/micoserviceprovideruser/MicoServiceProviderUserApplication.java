package org.imp.cloud.micoserviceprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicoServiceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceProviderUserApplication.class, args);
    }
}
