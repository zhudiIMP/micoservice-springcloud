package org.imp.cloud.micoservicerabbitmq.withboot;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    @RequestMapping(value = "/stopmq/{id}",method = RequestMethod.GET)
    public void stopRabbitMqListener(@PathVariable("id") String id){
        MessageListenerContainer container = rabbitListenerEndpointRegistry.getListenerContainer("aaa");
        if(container.isRunning()){
            container.stop();
            System.out.println("停止id为："+id+",的mq监听");
        }
    }

    @RequestMapping(value = "/startmq/{id}",method = RequestMethod.GET)
    public void startRabbitMqListener(@PathVariable("id") String id){
        MessageListenerContainer container = rabbitListenerEndpointRegistry.getListenerContainer("aaa");
        if(!container.isRunning()){
            container.start();
            System.out.println("启动id为："+id+",的mq监听");
        }
    }
}
