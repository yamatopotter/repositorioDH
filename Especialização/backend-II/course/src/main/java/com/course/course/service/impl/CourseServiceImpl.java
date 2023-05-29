package com.course.course.service.impl;

import com.course.course.service.CourseService;
import com.course.course.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService {
    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public String getSubscriptionPort(){
        return subscriptionService.getPort();
    }
}
