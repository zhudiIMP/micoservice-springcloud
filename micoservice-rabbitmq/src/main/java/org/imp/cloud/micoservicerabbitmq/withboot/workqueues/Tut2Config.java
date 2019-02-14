package org.imp.cloud.micoservicerabbitmq.withboot.workqueues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Tut2Config {


    @Bean
    public Queue hello() {
        return new Queue("hello");
    }


        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }


    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }
}
