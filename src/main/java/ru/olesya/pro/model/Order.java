package ru.olesya.pro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Subselect;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
//@Subselect("select * from order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double addressstartx;
    private Double addressstarty;
    private Double addressfinalx;
    private Double addressfinaly;
    private Long client;
    private Long tarif;

    public Order(Double addressstartx, Double addressstarty, Double addressfinalx, Double addressfinaly, Long client, Long tarif) {
        this.addressstartx = addressstartx;
        this.addressstarty = addressstarty;
        this.addressfinalx = addressfinalx;
        this.addressfinaly = addressfinaly;
        this.client = client;
        this.tarif = tarif;
    }
}
