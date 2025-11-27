package com.example.demo.sayhello;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    private final SayHelloService sayHelloService;

    public HelloController(SayHelloService sayHelloService)
    {
        this.sayHelloService = sayHelloService;
    }

    @PostMapping("/hello")
    public String sayHello(SayHelloDto sayHelloDto)
    {
        return sayHelloService.sayHello(sayHelloDto.id(), sayHelloDto.idioma());
    }

}
