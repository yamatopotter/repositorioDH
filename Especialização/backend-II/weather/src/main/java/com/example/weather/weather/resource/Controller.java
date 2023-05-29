package com.example.weather.weather.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("service")
public class Controller {
    @Value("${message}")
    private String message;

    @GetMapping
    public String message() { return message; }
}
