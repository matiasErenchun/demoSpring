package com.example.demo.sayhello;

import org.springframework.stereotype.Service;

@Service
public class SayHelloServiceDefault  implements SayHelloService
{
    public String sayHello()
    {
        return "Hello World! Spring Boot \uD83C\uDF31\uD83D\uDE80";
    }
}
