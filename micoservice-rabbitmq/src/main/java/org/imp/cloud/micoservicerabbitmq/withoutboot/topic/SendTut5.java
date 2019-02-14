package org.imp.cloud.micoservicerabbitmq.withoutboot.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendTut5 {
    private static final String EXCHANGE_NAME = "hello_topic_ex";
    private static final String[] NAME = {"Jim","Kevien"};

    public static void main(String[] argv) {
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost(Constant.rabbitmqAddr);
            connection = factory.newConnection();
            channel = connection.createChannel();
            //声明exchange
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            //声明队列
            channel.queueDeclare("hello_que_1", true, false, false, null);
            channel.queueDeclare("hello_que_2", true, false, false, null);
            //通过routingKey，将队列和exchange绑定
            channel.queueBind("hello_que_1", EXCHANGE_NAME, "hello.Jim");
            channel.queueBind("hello_que_2", EXCHANGE_NAME, "hello.#");
            for(int i = 0; i<10 ;i++){
                String message = "hello to " + NAME[i%2];
                String routingKey = "hello."+NAME[i%2];
                //发送消息
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
                System.out.println(" [x] Sent to'" + routingKey + "':'" + message + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

}
