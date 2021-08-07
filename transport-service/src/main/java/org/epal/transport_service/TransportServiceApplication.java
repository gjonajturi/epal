package org.epal.transport_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("org.epal.commons.transport*")
public class TransportServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransportServiceApplication.class, args);
    }

}
