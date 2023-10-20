package com.example.springsercurity.controller;

import com.example.springsercurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final AuthenticationService authenticationService;

    @GetMapping("/test")
    public ResponseEntity<String>login(){
        return ResponseEntity.ok("Authentication Success");
    }
}
