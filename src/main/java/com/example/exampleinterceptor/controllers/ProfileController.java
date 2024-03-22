package com.example.exampleinterceptor.controllers;

import com.example.exampleinterceptor.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("")
    public User get(HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        return user;
    }
    //Postman: Headers --> userId 1
}
