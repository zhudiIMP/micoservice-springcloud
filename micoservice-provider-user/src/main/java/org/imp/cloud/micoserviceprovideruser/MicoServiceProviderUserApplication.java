package org.imp.cloud.micoserviceprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages= {"org.imp.cloud"})
public class MicoServiceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceProviderUserApplication.class, args);
    }
}
