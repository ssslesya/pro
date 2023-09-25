package ru.olesya.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.olesya.pro.model.PetitionClients;

public interface PetitionClientsRepo extends JpaRepository<PetitionClients, Long> {
}
