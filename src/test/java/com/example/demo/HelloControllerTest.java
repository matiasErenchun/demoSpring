package com.example.demo;

import com.example.demo.sayhello.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)             // 👈 solo capa web
@Import(SayHelloServiceDefault.class)
class HelloControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GreetingRepository greetingRepository;

    @Test
    void holaEndpointDebeResponderHolaMundo() throws Exception {
        UUID requestId = UUID.randomUUID();
        String idioma = "es";

        // Lo que el servicio debería devolver
        GreetingRequest salida =
                new GreetingRequest(requestId,idioma);

        // Configuramos el mock
        when(greetingRepository.findByIdempotencyKey(requestId)).thenReturn(Optional.of(salida));

        // JSON de entrada (lo que manda el cliente)
        String jsonEntrada = """
                {
                  "requestId": "%s",
                  "idioma": "%s"
                }
                """.formatted(requestId, idioma);

        mockMvc.perform(
                post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEntrada)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World! Spring Boot \uD83C\uDF31\uD83D\uDE80"));
    }
}
