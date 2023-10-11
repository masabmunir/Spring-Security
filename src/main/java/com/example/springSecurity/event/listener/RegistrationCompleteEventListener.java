package com.example.springSecurity.event.listener;

import com.example.springSecurity.entity.User;
import com.example.springSecurity.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification Token for the User with the Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        // Send Mail to User
    }
}
