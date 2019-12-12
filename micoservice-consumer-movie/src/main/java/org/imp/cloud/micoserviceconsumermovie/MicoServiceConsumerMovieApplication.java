package org.imp.cloud.micoserviceconsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages= {"org.imp.cloud"})
public class MicoServiceConsumerMovieApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){return new RestTemplate();}

    public static void main(String[] args) {
        SpringApplication.run(MicoServiceConsumerMovieApplication.class, args);
    }
}
