package org.imp.cloud.micoservicerabbitmq.withoutboot.publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

public class SendTut3 {
    public static final String EXCHANGE_NAME = "hello_ex";

    public static void main(String args[]){
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(Constant.rabbitmqAddr);
            connection = factory.newConnection();
            channel = connection.createChannel();

            // 声明exchange为订阅模式 fanout
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            //声明队列
            channel.queueDeclare("hello_que_1", true, false, false, null);
            channel.queueDeclare("hello_que_2", true, false, false, null);
            //通过routingKey，将队列和exchange绑定
            channel.queueBind("hello_que_1", EXCHANGE_NAME, "");
            channel.queueBind("hello_que_2", EXCHANGE_NAME, "");
            int count = 0;
            while(true){
                count++;
                String msg = "hello_"+count;
                System.out.println("生产者发送消息："+msg);
                channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
                Thread.sleep(10);
                if(count>100){
                    break;
                }
            }
            System.out.println("end to dispatch tasks...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
