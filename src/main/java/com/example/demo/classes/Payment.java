package com.example.demo.classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private LocalDate paymentDate;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Payment() {}

    public Payment(double amount, LocalDate paymentDate, Reservation reservation) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Reservation getReservation() {
        return reservation;
    }
}