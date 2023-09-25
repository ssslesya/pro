package ru.olesya.pro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ride")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderid;
    private Long driver;
    private Long statuss;

    public Ride(Long orderid, Long driver, Long statuss) {
        this.orderid = orderid;
        this.driver = driver;
        this.statuss = statuss;
    }
}
