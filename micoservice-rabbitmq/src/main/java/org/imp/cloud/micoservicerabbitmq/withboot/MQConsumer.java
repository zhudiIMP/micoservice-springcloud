package org.imp.cloud.micoservicerabbitmq.withboot;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class MQConsumer {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1", durable="true"),
            exchange = @Exchange(value = "exchange-1", durable="true",type= "topic",ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    ), id = "aaa"
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        // 启用QoS，每次预取5条消息，避免消息处理不过来，全部堆积在本地缓存里
        channel.basicQos(0 ,5, false);
        System.err.println("--------------------------------------");
        System.err.println("消费端Payload: " + message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag, false);
    }
}
