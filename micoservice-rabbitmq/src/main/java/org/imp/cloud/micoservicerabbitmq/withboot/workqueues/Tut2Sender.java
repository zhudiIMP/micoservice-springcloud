package org.imp.cloud.micoservicerabbitmq.withboot.workqueues;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut2Sender {


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    int count = 0;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void send() {
        while (true) {
            String message = "Hello_"+Integer.toString(++count);
            template.convertAndSend(queue.getName(), message);
            System.out.println(" [x] Sent '" + message + "'");
            if(count > 10) break;
        }
    }
}
