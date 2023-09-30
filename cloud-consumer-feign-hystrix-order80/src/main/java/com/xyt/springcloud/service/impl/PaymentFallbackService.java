package com.xyt.springcloud.service.impl;

import com.xyt.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Long id) {
        return "***** PaymentFallbackService fall back  paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Long id) {
        return "***** PaymentFallbackService fall back  paymentInfo_timeout";    }
}
