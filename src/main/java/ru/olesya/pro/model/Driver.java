package ru.olesya.pro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String fullname;
    private String passport;
    private String license;
    private String car;
    private Long tarif;

    public Driver(Long id, String phone, String fullname, String passport, String license, String car, Long tarif) {
        this.id = id;
        this.phone = phone;
        this.fullname = fullname;
        this.passport = passport;
        this.license = license;
        this.car = car;
        this.tarif = tarif;
    }

    public Driver(String phone, String fullname, String passport, String license, String car, Long tarif) {
        this.phone = phone;
        this.fullname = fullname;
        this.passport = passport;
        this.license = license;
        this.car = car;
        this.tarif = tarif;
    }
}
