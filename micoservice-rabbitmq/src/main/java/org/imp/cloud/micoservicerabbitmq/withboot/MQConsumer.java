package org.imp.cloud.micoservicerabbitmq.withboot;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.amqp.core.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import java.nio.charset.Charset;

@Component
public class MQConsumer {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1", durable="true"),
            exchange = @Exchange(value = "exchange-1", durable="true",type= "topic",ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    ), id = "aaa",autoStartup="false"
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws Exception {
        // 启用QoS，每次预取5条消息，避免消息处理不过来，全部堆积在本地缓存里
        channel.basicQos(0 ,5, false);
        System.out.println("---消费者消费---");
        try{
            String msg = new String(message.getBody(),Charset.forName("UTF-8"));
            System.out.println("消费端Payload: " + msg);
        }catch (Exception e){
            System.out.println("消费发生异常后的异常处理");
        }finally {
            channel.basicAck(deliveryTag, false);
        }
    }
}
