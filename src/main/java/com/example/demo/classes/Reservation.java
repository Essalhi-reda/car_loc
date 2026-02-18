package com.example.demo.classes;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "reservations")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Date de début et de fin de location
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Prix total calculé
    private double prixTotal;

    // RELATION : Plusieurs réservations peuvent appartenir à UN client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // RELATION : Plusieurs réservations peuvent concerner UNE voiture
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    public Reservation() {
    }

    // 2. Constructeur complet (Utile pour les tests ou le mapping)
    public Reservation(int id, LocalDate dateDebut, LocalDate dateFin, double prixTotal, Client client, Car car) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.client = client;
        this.car = car;
    }

    // 3. Constructeur sans l'ID (Le plus utilisé pour créer une nouvelle réservation)
    public Reservation(LocalDate dateDebut, LocalDate dateFin, double prixTotal, Client client, Car car) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
        this.client = client;
        this.car = car;
    }
    public void calculerPrix(double prixJournalier) {
        long jours = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
        this.prixTotal = jours * prixJournalier;
    }
}
