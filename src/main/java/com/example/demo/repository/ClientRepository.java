package com.example.demo.repository;


import com.example.demo.classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Magique : tu as déjà accès aux méthodes .save(), .findAll(), .deleteById()...
}

