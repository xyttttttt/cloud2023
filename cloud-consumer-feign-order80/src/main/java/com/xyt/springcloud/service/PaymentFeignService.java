package com.xyt.springcloud.service;

import com.xyt.springcloud.entities.CommonResult;
import com.xyt.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

//    public int create(Payment payment);
    @RequestMapping(value = "/payment/create" ,method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
