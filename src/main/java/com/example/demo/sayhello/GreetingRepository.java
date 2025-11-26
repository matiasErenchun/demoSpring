package com.example.demo.sayhello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GreetingRepository extends JpaRepository<GreetingRequest, UUID>
{

}
