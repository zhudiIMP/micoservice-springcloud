package org.imp.cloud.micoservicerabbitmq.withboot.routing;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    private int index;

    private int count;

    private final String[] keys = {"orange", "black", "green"};

    @Scheduled(fixedDelay = 10000, initialDelay = 500)
    public void send() {
        System.out.print("123");
        for(int i=0;i<5;i++){
            template.convertAndSend(direct.getName(), "orange", "Hello to orange_"+i);
            template.convertAndSend(direct.getName(), "black", "Hello to black_"+i);
            template.convertAndSend(direct.getName(), "green", "Hello to green_"+i);
        }
    }
}
