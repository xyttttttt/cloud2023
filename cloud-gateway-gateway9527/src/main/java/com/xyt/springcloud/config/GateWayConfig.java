package com.xyt.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){

        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();

        routes.route("path_route_xyt",r -> r.path("/guonei").uri("https://www.yhchj.com")).build();
        return routes.build();
    }
}
