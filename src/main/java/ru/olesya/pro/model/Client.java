package ru.olesya.pro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    private String id;
    private String name;
    private String password;

    public Client(String name, String id, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Client(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
