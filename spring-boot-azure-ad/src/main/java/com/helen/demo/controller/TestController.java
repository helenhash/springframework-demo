package com.helen.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("Admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }
}
