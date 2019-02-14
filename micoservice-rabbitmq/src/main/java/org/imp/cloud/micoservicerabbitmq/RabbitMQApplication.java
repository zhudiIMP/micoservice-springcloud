package org.imp.cloud.micoservicerabbitmq;

import org.imp.cloud.micoservicerabbitmq.withboot.simplest.Tut1Receiver;
import org.imp.cloud.micoservicerabbitmq.withboot.simplest.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaServer
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
