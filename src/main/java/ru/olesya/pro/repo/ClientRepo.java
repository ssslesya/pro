package ru.olesya.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.olesya.pro.model.Client;

public interface ClientRepo extends JpaRepository<Client, String> {
    Client findByIdAndPassword(String id, String password);
}
