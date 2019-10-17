package org.imp.cloud.micoservicerabbitmq.withboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQApplicationTut5 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut5.class, args);
    }
}
