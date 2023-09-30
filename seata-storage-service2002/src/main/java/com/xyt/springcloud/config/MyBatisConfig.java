package com.xyt.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.xyt.springcloud.dao"})
public class MyBatisConfig {
}
