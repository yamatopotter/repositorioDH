package com.course.course.service;

import com.course.course.config.CustomLoadBalancer;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SUBSCRIPTION-SERVICE")
@LoadBalancerClient(value = "SUBSCRIPTION-SERVICE", configuration = CustomLoadBalancer.class)
public interface SubscriptionService {
    @GetMapping("/subscription/port")
    String getPort();
}
