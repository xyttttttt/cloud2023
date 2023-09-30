package com.xyt.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xyt.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        return result;
    }

  /*  @HystrixCommand(fallbackMethod ="paymentTimeoutFallbackMethod",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")})*/
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
//        int age =10/0;
        String result = paymentHystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentTimeoutFallbackMethod(Long id){
        return "俺是80客户端，对方支付系统忙碌请10秒钟之后再试，"+"(ㄒoㄒ)/~~";
    }

    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
