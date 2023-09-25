package ru.olesya.pro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "petitiondrivers")
public class PetitionDrivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ride;
    private String text;
    private Long star;

    public PetitionDrivers(Long ride, String text, Long star) {
        this.ride = ride;
        this.text = text;
        this.star = star;
    }
}
