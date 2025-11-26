package com.example.demo;

import com.example.demo.sayhello.GreetingRepository;
import com.example.demo.sayhello.GreetingRequest;
import com.example.demo.sayhello.SayHelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class HelloControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SayHelloService sayHelloService;

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
        when(greetingRepository.findById(requestId)).thenReturn(Optional.of(salida));

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
                .andExpect(content().string("I greet you again"));
    }
}
