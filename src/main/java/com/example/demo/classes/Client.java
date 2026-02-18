package com.example.demo.classes;
import jakarta.persistence.*;


@Entity
@Table(name = "clients")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private String numero_phone; // (Rappel: un String serait mieux ici 😉)

    // --- CONSTRUCTEURS ---
    public Client() {}

    public Client(int id, String name, String location, String numero_phone) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.numero_phone = numero_phone;
    }

    // --- GETTERS ET SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumero_phone() {
        return numero_phone;
    }

    public void setNumero_phone(String numero_phone) {
        this.numero_phone = numero_phone;
    }
}