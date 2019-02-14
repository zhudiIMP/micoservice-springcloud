package org.imp.cloud.micoservicerabbitmq.withstream;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Sender {
    @Resource
    private Barista output; // 消息的发送管道

    public void send(String message) {
        this.output.messageOutput().send(MessageBuilder.withPayload(message).build()); // 创建并发送消息
    }
}
