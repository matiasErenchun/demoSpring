package com.example.demo.sayhello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    private final SayHelloService sayHelloService;

    public HelloController(SayHelloService sayHelloService)
    {
        this.sayHelloService = sayHelloService;
    }

    @GetMapping("/hello")
    public String sayHello()
    {
        return sayHelloService.sayHello();
    }
}
