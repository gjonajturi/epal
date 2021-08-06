package org.epal.transport_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transport_company")
public class TransportCompanyController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello";
    }
}
