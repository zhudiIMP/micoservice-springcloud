package org.imp.cloud.micoservicerabbitmq.withboot.publish;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class Tut3Config {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("hello_ex");
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new Queue("hello_que_2");
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new Queue("hello_que_1");
    }

    @Bean
    public Binding binding1(FanoutExchange fanout,
                            Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout,
                            Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
    }

    @Bean
    public Tut3Receiver receiver() {
        return new Tut3Receiver();
    }

    @Bean
    public Tut3Sender sender() {
        return new Tut3Sender();
    }
}
