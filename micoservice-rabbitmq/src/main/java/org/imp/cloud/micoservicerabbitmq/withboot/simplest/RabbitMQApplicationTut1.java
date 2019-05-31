package org.imp.cloud.micoservicerabbitmq.withboot.simplest;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class RabbitMQApplicationTut1 {

    @Bean
    public Queue hello() {
    return new Queue("hello");
}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut1.class, args);
    }
}
