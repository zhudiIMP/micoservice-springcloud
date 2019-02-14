package org.imp.cloud.micoservicerabbitmq.withoutboot.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.imp.cloud.micoservicerabbitmq.withoutboot.constant.Constant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendTut2 {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(Constant.rabbitmqAddr);
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //定义8个任务
            String[] tasks = {"task1", "task2", "task3", "task4", "task5", "task6", "task7", "task8"};
            System.out.println("start to dispatch tasks...");
            //分发任务
            for (String task : tasks) {
                channel.basicPublish("", QUEUE_NAME, null, task.getBytes());
                System.out.println("生产者发送消息：" + task);
            }
            System.out.println("end to dispatch tasks...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }


    }
}