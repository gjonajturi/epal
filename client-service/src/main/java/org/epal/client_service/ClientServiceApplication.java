package org.epal.client_service;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //Enables non-blocking & with load-balanced  rest clients with service discovery
@EntityScan("org.epal.commons.client.*")
public class ClientServiceApplication {

    private final BeanFactory beanFactory;

    @Autowired
    public ClientServiceApplication(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
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


    //=================================================
    //Applies traceable request-Id to outgoing requests to outside microservice
    @Bean(name="traceableExecutorService")
    public ExecutorService  traceableExecutorService(){
        ExecutorService executorService= Executors.newCachedThreadPool();
        return new TraceableExecutorService(beanFactory,executorService);
    }


    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }


}


