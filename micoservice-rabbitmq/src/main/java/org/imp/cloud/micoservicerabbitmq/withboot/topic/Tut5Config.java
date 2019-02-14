package org.imp.cloud.micoservicerabbitmq.withboot.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topic(){
        return new TopicExchange("hello_topic_ex");
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
    public Binding binding1a(TopicExchange topic,
                             Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("hello.Jim");
    }


    @Bean
    public Binding binding2a(TopicExchange direct,
                             Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(direct)
                .with("hello.#");
    }


    @Bean
    public Tut5Receiver receiver() {
        return new Tut5Receiver();
    }

    @Bean
    public Tut5Sender sender() {
        return new Tut5Sender();
    }
}
