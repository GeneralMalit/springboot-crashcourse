package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${app.greeting.message}")
    private String customGreeting;
    @GetMapping("/hello")
    public String sayHello() {
        return customGreeting;
    }
}