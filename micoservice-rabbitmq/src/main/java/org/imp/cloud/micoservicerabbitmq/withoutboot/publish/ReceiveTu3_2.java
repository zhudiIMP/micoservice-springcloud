package org.imp.cloud.micoservicerabbitmq.withoutboot.publish;

import com.rabbitmq.client.*;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

import java.io.IOException;

public class ReceiveTu3_2 {
    public static final String QUEUE_NAME = "hello_que_2";

    public static void main(String args[]){
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try{
            factory = new ConnectionFactory();
            factory.setHost(Constant.rabbitmqAddr);

            connection = factory.newConnection();
            channel = connection.createChannel();
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] ReceiveTut3_2 Received '" + message + "'");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        System.out.println(" [x] Done");
                    }
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
