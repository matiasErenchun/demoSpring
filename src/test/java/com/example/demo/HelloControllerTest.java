package com.example.demo;

import com.example.demo.sayhello.SayHelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SayHelloService sayHelloService;

    @Test
    void holaEndpointDebeResponderHolaMundo() throws Exception {

        when(sayHelloService.sayHello())
                .thenReturn("Hello World! Spring Boot \uD83C\uDF31\uD83D\uDE80");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World! Spring Boot \uD83C\uDF31\uD83D\uDE80"));
    }
}
