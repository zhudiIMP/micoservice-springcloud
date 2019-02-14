package org.imp.cloud.micoservicerabbitmq.withoutboot.topic;

import com.rabbitmq.client.*;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

import java.io.IOException;

public class ReceiveTu5_1 {

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.rabbitmqAddr);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("hello_que_1", true, false, false, null);
        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume("hello_que_1", true, consumer);
    }
}
