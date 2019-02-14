package org.imp.cloud.micoservicerabbitmq.withboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut5Receiver {

    @RabbitListener(queues = "hello_que_1")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "hello_que_2")
    public void receive2(String in) throws InterruptedException {
        receive(in, 2);
    }

    public void receive(String in, int receiver) throws InterruptedException {

        System.out.println("instance " + receiver + " [x] Received '" + in + "'");

    }

}
