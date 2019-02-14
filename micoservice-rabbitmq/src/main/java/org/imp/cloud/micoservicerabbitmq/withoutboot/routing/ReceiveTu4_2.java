package org.imp.cloud.micoservicerabbitmq.withoutboot.routing;

import com.rabbitmq.client.*;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;
import org.springframework.amqp.core.Queue;

import java.io.IOException;

public class ReceiveTu4_2 {


    private static final String EXCHANGE_NAME = "hello_direct_ex";
    private static final String[] ROUTINGKEY = {"black","green","orange"};

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.rabbitmqAddr);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare("hello_que_2", true, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume("hello_que_2", true, consumer);
    }
}
