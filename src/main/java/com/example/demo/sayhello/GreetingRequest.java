package com.example.demo.sayhello;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="greeting_request")
public class GreetingRequest
{
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 50)
    private String idioma;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    protected GreetingRequest() { }

    public GreetingRequest(UUID id,String idioma) {
        this.id = id;
        this.idioma = idioma;
    }

    public UUID getId() {
        return id;
    }

    public String getIdioma() {
        return idioma;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}
