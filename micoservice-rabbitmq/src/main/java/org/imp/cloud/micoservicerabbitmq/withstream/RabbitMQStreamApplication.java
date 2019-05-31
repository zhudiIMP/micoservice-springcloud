package org.imp.cloud.micoservicerabbitmq.withstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Barista.class)
@EnableScheduling
public class RabbitMQStreamApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQStreamApplication.class, args);

    }
}
