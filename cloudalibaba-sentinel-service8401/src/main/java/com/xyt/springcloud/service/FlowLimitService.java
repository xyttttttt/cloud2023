package com.xyt.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitService {

    @SentinelResource("test1")
    public void test1(){
        System.out.println("service .........test1");
    }
}
