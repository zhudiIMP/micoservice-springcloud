package org.imp.cloud.micoservicerabbitmq.withboot.topic;

import org.imp.cloud.micoservicerabbitmq.withstream.Barista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQApplicationTut5 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut5.class, args);
    }
}
