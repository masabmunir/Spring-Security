package com.example.springSecurity.controller;

import com.example.springSecurity.entity.User;
import com.example.springSecurity.event.RegistrationCompleteEvent;
import com.example.springSecurity.model.UserModel;
import com.example.springSecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){

        User user = userService.registerUser(userModel);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
        String url = "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
        log.info("Generated application URL: {}", url);
        return url;
    }
}
