package org.imp.cloud.micoservicerabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class RabbitMQApplication {

    @Bean
    public Queue hello() {
    return new Queue("hello");
}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
