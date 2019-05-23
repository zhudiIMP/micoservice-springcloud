package org.imp.cloud.micoservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MicoserviceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoserviceZuulApplication.class, args);
    }

}
