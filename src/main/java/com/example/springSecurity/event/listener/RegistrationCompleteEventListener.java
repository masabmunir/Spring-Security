package com.example.springSecurity.event.listener;

import com.example.springSecurity.entity.User;
import com.example.springSecurity.event.RegistrationCompleteEvent;
import com.example.springSecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification Token for the User with the Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        // Send Mail to User

        String url = event.getApplicationUrl() + "verifyRegistration?token="+token;

        //SendVerificationEmail
        log.info("Click the link to verify your account:{}", url);
    }
}
