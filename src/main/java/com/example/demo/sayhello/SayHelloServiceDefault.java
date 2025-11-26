package com.example.demo.sayhello;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SayHelloServiceDefault  implements SayHelloService
{
    private final GreetingRepository greetingRepository;

    public SayHelloServiceDefault(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String sayHello(UUID id, String idioma)
    {
        Optional<GreetingRequest> existente = greetingRepository.findById(id);
        if (existente.isPresent()) {
            return "I greet you again";
        }
        return "Hello World! Spring Boot \uD83C\uDF31\uD83D\uDE80";
    }
}
