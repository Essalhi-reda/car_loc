package com.example.demo.classes;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int pricePerDay;
    private String status;
    private String image_url;

    public Car() {
    }

    public Car(String brand, String model, int pricePerDay, String status, String image_url) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.status = status;
        this.image_url = image_url;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getPricePerDay() {
        return this.pricePerDay;
    }

    public String getStatus() {
        return this.status;
    }

    public String getImageUrl() {
        return this.image_url;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }


}

