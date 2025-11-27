package com.example.demo.sayhello;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="greeting_request")
public class GreetingRequest
{
    @Getter
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "idempotency_key", nullable = false, unique = true)
    private UUID idempotencyKey;

    @Getter
    @Column(nullable = false, length = 50)
    private String idioma;

    @Getter
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Getter
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    protected GreetingRequest() { }

    public GreetingRequest(UUID id,String idioma) {
        this.idempotencyKey = id;
        this.idioma = idioma;
    }

}
