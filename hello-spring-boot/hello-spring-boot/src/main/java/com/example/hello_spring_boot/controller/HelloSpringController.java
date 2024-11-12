package com.example.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    String sayHello() {
        return "Hello spring boot";
    }

}
