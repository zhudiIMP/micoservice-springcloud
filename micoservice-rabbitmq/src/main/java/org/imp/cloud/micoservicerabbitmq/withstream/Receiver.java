package org.imp.cloud.micoservicerabbitmq.withstream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Barista.class)
public class Receiver {
    @StreamListener(Barista.HELLO_INPUT)
    public void input(String msg) {
        System.out.println("【*** 消息接收 ***】" + msg);
    }
}
