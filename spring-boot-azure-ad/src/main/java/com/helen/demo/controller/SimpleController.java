package com.helen.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('APPROLE_READ')")
    public String home(){
        return "Welcome api";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('APPROLE_WRITE')")
    public String getData(){
        return "Can see and update data.";
    }
}
