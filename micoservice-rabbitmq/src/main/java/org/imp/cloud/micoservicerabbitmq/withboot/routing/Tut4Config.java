package org.imp.cloud.micoservicerabbitmq.withboot.routing;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut4Config {

    @Bean
    public DirectExchange direct(){
        return new DirectExchange("hello_direct_ex");
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new Queue("hello_que_1");
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new Queue("hello_que_2");
    }

    @Bean
    public Binding binding1a(DirectExchange direct,
                             Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(direct)
                .with("orange");
    }

    @Bean
    public Binding binding1b(DirectExchange direct,
                             Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(direct)
                .with("black");
    }

    @Bean
    public Binding binding2a(DirectExchange direct,
                             Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(direct)
                .with("green");
    }

    @Bean
    public Binding binding2b(DirectExchange direct,
                             Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(direct)
                .with("black");
    }

    @Bean
    public Tut4Receiver receiver() {
        return new Tut4Receiver();
    }

    @Bean
    public Tut4Sender sender() {
        return new Tut4Sender();
    }
}
