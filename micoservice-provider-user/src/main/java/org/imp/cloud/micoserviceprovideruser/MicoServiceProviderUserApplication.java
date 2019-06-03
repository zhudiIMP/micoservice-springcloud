package org.imp.cloud.micoserviceprovideruser;

import org.imp.cloud.micoserviceprovideruser.stream.Barista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Barista.class)
@EnableScheduling
public class MicoServiceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceProviderUserApplication.class, args);
    }
}
