package org.imp.cloud.micoservicerabbitmq.withboot.topic;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut5Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    @Scheduled(fixedDelay = 10000, initialDelay = 500)
    public void send() {
        for(int i=0;i<5;i++){
            template.convertAndSend(topic.getName(), "hello.Jim", "Hello to Jim_"+i);
            template.convertAndSend(topic.getName(), "hello.Kevin", "Hello to Kevin_"+i);
        }
    }
}
