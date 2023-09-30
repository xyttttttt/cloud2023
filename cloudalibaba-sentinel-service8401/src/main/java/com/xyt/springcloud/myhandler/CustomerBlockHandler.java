package com.xyt.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xyt.springcloud.entities.CommonResult;
import com.xyt.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException--------1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException---------2");
    }
}
