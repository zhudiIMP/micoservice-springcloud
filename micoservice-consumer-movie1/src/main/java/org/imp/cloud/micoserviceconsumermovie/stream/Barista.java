package org.imp.cloud.micoserviceconsumermovie.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {

    String HELLO_OUTPUT = "hello_output";

    String HELLO_INPUT = "hello_input";

    @Output(HELLO_OUTPUT)
    MessageChannel messageOutput();

    @Input(HELLO_INPUT)
    SubscribableChannel messageInput();
}
