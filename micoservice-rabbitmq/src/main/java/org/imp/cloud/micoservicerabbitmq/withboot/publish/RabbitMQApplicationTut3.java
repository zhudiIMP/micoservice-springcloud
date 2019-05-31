package org.imp.cloud.micoservicerabbitmq.withboot.publish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class RabbitMQApplicationTut3 {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut3.class, args);
    }
}
