package com.helen.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }
}
