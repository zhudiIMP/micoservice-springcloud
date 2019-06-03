package org.imp.cloud.micoserviceconsumermovie;

import org.imp.cloud.micoserviceconsumermovie.stream.Barista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"org.imp.cloud"})
@EnableBinding(Barista.class)
public class MicoServiceConsumerMovieApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){return new RestTemplate();}

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceConsumerMovieApplication.class, args);
    }
}
