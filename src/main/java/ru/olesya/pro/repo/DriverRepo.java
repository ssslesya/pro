package ru.olesya.pro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.olesya.pro.model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long> {
    Driver findByPhone(String phone);
}
