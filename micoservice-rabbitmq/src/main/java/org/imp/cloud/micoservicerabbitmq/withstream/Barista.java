package org.imp.cloud.micoservicerabbitmq.withstream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface Barista {

     String HELLO_OUTPUT = "hello_output";

     String HELLO_INPUT = "hello_input";

     @Output(HELLO_OUTPUT)
     MessageChannel messageOutput();

     @Input(HELLO_INPUT)
     SubscribableChannel messageInput();
}
