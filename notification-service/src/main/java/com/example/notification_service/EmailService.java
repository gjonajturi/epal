package com.example.notification_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    public void sendEmail(String content){
        log.info("Called : sendEmail() with argument : "+content);
    }
}
