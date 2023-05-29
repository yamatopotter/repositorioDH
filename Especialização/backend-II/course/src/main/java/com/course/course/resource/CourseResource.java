package com.course.course.resource;

import com.course.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseResource {
    @Autowired
    private CourseService service;

    @GetMapping("/subscription/port")
    public ResponseEntity<String> getMessage() {
        String port =  service.getSubscriptionPort();
        System.out.println(port);
        return ResponseEntity.ok(port);
    }
}
