package org.imp.cloud.micoservicerabbitmq.withoutboot.simplest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

public class SendTut1 {


    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.rabbitmqAddr);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        int count = 0;
        while(true){
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            Thread.sleep(1000);
            count++;
            if(count == 100){
                break;
            }
        }

        channel.close();
        connection.close();
    }
}
