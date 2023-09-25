package ru.olesya.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.olesya.pro.model.Ride;

public interface RideRepo extends JpaRepository<Ride, Long> {
    Ride findByOrderid(Long id);
}
