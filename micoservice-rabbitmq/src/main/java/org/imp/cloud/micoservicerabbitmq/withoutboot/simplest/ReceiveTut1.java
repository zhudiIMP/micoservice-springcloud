package org.imp.cloud.micoservicerabbitmq.withoutboot.simplest;
import com.rabbitmq.client.*;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

import java.io.IOException;

public class ReceiveTut1 {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.rabbitmqAddr);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };

        channel.basicConsume(QUEUE_NAME, consumer);
    }

}