package ru.olesya.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.olesya.pro.exceptions.UserExistException;
import ru.olesya.pro.model.*;
import ru.olesya.pro.repo.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/taxi")
//@AllArgsConstructor
public class ClientController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private TarifRepo tarifRepo;
    @Autowired
    private PetitionClientsRepo petitionClientsRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private RideRepo rideRepo;

    @PostMapping("/new-order")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        orderRepo.save(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/delete-order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepo.deleteById(id);
    }
    @PostMapping("/ride/{id}")
    public ResponseEntity<?> getRide(@PathVariable Long id){
        if (rideRepo.findByOrderid(id)==null){
            throw new UserExistException("водитель не найден");
        }
        return ResponseEntity.ok(rideRepo.findByOrderid(id));
    }
    @PostMapping("/driver-car/{id}")
    public ResponseEntity<?> driverCar(@PathVariable Long id) {
        return ResponseEntity.ok(driverRepo.findById(id));
    }
    @PostMapping("/add-driver")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver){
        driverRepo.save(driver);
        return ResponseEntity.ok(driver);
    }
    @PostMapping("/new-petition")
    public void addPetition(@RequestBody PetitionClients petitionClients){
        petitionClientsRepo.save(petitionClients);
    }
}
