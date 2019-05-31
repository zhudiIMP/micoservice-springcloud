package org.imp.cloud.micoservicerabbitmq.withstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendMessage {

    @Autowired
    private Sender sender;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        for(int i=0;i<5;i++){
            //System.out.println("send to mq:"+i);
            sender.send("hello");
        }

    }
}
