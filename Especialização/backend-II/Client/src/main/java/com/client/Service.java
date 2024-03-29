package com.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class Service {

    @Value("${message}")
    private String message;

    @GetMapping
    public ResponseEntity<String> getString(){
        return ResponseEntity.ok("clientResource");
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(this.message);
    }
}
