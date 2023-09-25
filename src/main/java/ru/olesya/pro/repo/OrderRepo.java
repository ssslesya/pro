package ru.olesya.pro.repo;

import ru.olesya.pro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByTarif(Long tarif);
    void deleteById(Long id);
//    List<Order> findByClient();
}
