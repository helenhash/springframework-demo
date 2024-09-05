package com.helen.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

}
