package com.xyt.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xyt.springcloud.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Autowired
    FlowLimitService service;

    @GetMapping("/testA")
    public String testA()
    {
     /*   try{
            TimeUnit.MILLISECONDS.sleep(800);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
        service.test1();
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        service.test1();
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        return "------testD";
    }

    @GetMapping("/testC")
    public String testC()
    {
       int age =10/0;
        return "------testC 异常比例";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotKey")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotkey";
    }


    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "deal_testHotKey，/(ㄒoㄒ)/~~";
    }
}
