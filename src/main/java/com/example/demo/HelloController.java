package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tells Spring: this class handles web requests and returns data
public class HelloController {

    @GetMapping("/hello") // runs when someone opens /hello in the browser
    public String hello() {
        return "Hello Samarth, my first Spring Boot API!"; // this text goes back to the browser
    }
}