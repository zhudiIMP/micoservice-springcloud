package org.imp.cloud.micoservicerabbitmq.withboot.workqueues;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaServer
@SpringBootApplication
@EnableScheduling
public class RabbitMQApplicationTut2 {

    @Bean
    public Queue hello() {
    return new Queue("hello");
}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplicationTut2.class, args);
    }
}