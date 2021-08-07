package org.epal.client_service;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //Enables non-blocking & with load-balanced  rest clients with service discovery
@EntityScan("org.epal.commons.client.*")
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }


    //Request interceptor on client-service
    @Bean
    public RequestInterceptor requestTokenBearerInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                //Get authentication from security context
               Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
               requestTemplate.header("Authorization","Bearer "+"xvadfsdfsa");
            }
        };
    }

}


