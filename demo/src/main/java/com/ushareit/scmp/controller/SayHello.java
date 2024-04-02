package com.ushareit.scmp.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/say")
@Api(tags = "Hello Management")
public class SayHello {
    String world = "World";
    @Autowired
    private MeterRegistry meterRegistry;

    @Value("${spring.application.name}")
    private String appname;
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        if(name == null) {
            meterRegistry.counter("hello_req_has_name", Tags.of("name", "false")).increment();
            return "i am "+appname+" hello"+ world;
        }else {
            meterRegistry.counter("hello_req_has_name", Tags.of("name", "true")).increment();
            return "i am "+appname+" hello"+ name;
        }
    }
}