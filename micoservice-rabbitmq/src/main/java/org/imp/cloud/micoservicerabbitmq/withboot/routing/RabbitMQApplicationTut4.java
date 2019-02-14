package org.imp.cloud.micoservicerabbitmq.withboot.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQApplicationTut4 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut4.class, args);
    }
}
