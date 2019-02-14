package org.imp.cloud.micoservicebpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

@SpringBootApplication
@EnableProcessApplication
public class MicoServiceBPMApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceBPMApplication.class, args);
    }
}
