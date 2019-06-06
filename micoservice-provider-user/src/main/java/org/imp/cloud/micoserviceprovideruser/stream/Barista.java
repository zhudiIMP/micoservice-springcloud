package org.imp.cloud.micoserviceprovideruser.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface Barista {

     String HELLO_OUTPUT = "hello_output";

     @Output(HELLO_OUTPUT)
     MessageChannel messageOutput();
}
