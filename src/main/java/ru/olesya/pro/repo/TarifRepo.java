package ru.olesya.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.olesya.pro.model.Tarif;

public interface TarifRepo extends JpaRepository<Tarif, Long> {
}
