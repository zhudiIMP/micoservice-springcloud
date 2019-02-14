package org.imp.cloud.micoservicerabbitmq.withoutboot.routing;

import com.rabbitmq.client.*;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;
import org.springframework.amqp.core.Queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendTut4 {
    private static final String EXCHANGE_NAME = "hello_direct_ex";
    private static final String[] ROUTINGKEY = {"black","green","orange"};

    public static void main(String[] argv) {
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost(Constant.rabbitmqAddr);
            connection = factory.newConnection();
            channel = connection.createChannel();
            //声明队列
            channel.queueDeclare("hello_que_1", true, false, false, null);
            channel.queueDeclare("hello_que_2", true, false, false, null);

            //声明exchange
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            //通过routingKey，将队列和exchange绑定
            channel.queueBind("hello_que_1", EXCHANGE_NAME, ROUTINGKEY[0]);
            channel.queueBind("hello_que_2", EXCHANGE_NAME, ROUTINGKEY[1]);
            channel.queueBind("hello_que_2", EXCHANGE_NAME, ROUTINGKEY[2]);
            //启用消息确认机制
            channel.confirmSelect();
            //消息确认监听
            channel.addConfirmListener(new ConfirmListener(){
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("[AsynConfirmSend] handleAck : deliveryTag = " + deliveryTag + " multiple = " + multiple);
                }
                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("[AsynConfirmSend] handleNack : deliveryTag = " + deliveryTag + " multiple = " + multiple);
                }
            });
            for(int i = 0; i<100 ;i++){
                String message = "hello to " + ROUTINGKEY[i%3];
                //发送消息，设置deliverMode 为2，持久化消息
                channel.basicPublish(EXCHANGE_NAME, ROUTINGKEY[i%3], MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                System.out.println(" [x] Sent to'" + ROUTINGKEY[i%3] + "':'" + message + "'");
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

