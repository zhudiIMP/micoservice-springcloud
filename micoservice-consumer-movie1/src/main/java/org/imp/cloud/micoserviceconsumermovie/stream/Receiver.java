package org.imp.cloud.micoserviceconsumermovie.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @StreamListener(Barista.HELLO_INPUT)
    public void input(Message<String> message) {
        System.out.println("【*** Receiver-消息接收 ***】" + message.getPayload());
    }
}
