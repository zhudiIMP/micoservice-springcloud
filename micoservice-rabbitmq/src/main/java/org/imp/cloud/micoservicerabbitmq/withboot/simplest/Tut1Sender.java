package org.imp.cloud.micoservicerabbitmq.withboot.simplest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class Tut1Sender {


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(cron="0/3 * * * * ? ")
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
