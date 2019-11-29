package org.imp.cloud.micoserviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicoserviceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicoserviceConfigApplication.class, args);
    }

}
