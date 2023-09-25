package ru.olesya.pro.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.olesya.pro.exceptions.UserExistException;
import ru.olesya.pro.model.*;
import ru.olesya.pro.repo.DriverRepo;
import ru.olesya.pro.repo.OrderRepo;
import ru.olesya.pro.repo.PetitionDriversRepo;
import ru.olesya.pro.repo.RideRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@CrossOrigin
@RestController
@RequestMapping("/taxi/driver")
public class DriverController {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private PetitionDriversRepo petitionDriversRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private RideRepo rideRepo;
    @PostMapping("/get-driver")
    public ResponseEntity<?> getDriver(@RequestBody String phone){
        if(driverRepo.findByPhone(phone).getId()==null)
            throw new UserExistException("надо регать");
        return ResponseEntity.ok(driverRepo.findByPhone(phone));
    }
    @PostMapping("/get-order/{tarif}")
    public ResponseEntity<?> getOrders(@PathVariable Long tarif, @RequestBody Coords c) {
        List<Order> orders = new ArrayList<>();
        for (Order o: orderRepo.findAllByTarif(tarif)) {
            if(rideRepo.findByOrderid(o.getId())==null){
                orders.add(o);
            }
        }
        Map<Order, Double> map = new HashMap<>();
        for (Order o:orders) {
            map.put(o, c.distancePoint(o.getAddressstartx(), o.getAddressstarty()));
        }
        return ResponseEntity.ok(c.sort(map));
    }
    @GetMapping("order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderRepo.findById(id).orElseThrow());
    }
    @PostMapping("/create-ride")
    public ResponseEntity<?> addRide(@RequestBody Ride ride){
        rideRepo.save(ride);
        return ResponseEntity.ok(ride);
    }
    @PostMapping("/update-ride/{id}")
    public ResponseEntity<?> updateStatusRide(@PathVariable Long id, @RequestBody Long status){
        Ride ride = rideRepo.findById(id).orElseThrow();
        ride.setStatuss(status);
        rideRepo.save(ride);
        return ResponseEntity.ok(ride);
    }
    @DeleteMapping("/delete-order/{id}")
    public void deleteOrderById(@PathVariable Long id){
        orderRepo.deleteById(id);
    }
    @PostMapping("/new-petition")
    public void addPetition(@RequestBody PetitionDrivers petitionDrivers){
        petitionDriversRepo.save(petitionDrivers);
    }
}
