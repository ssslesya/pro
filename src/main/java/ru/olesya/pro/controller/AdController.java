package ru.olesya.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.olesya.pro.exceptions.UserExistException;
import ru.olesya.pro.model.*;
import ru.olesya.pro.repo.ClientRepo;
import ru.olesya.pro.repo.DriverRepo;
import ru.olesya.pro.repo.PetitionClientsRepo;
import ru.olesya.pro.repo.PetitionDriversRepo;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/taxi/ad")
public class AdController {
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private PetitionClientsRepo petitionClientsRepo;
    @Autowired
    private PetitionDriversRepo petitionDriversRepo;
    @GetMapping("/drivers")
    public List<Driver> getDrivers(){
        return driverRepo.findAll();
    }
    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientRepo.findAll();
    }
    @DeleteMapping("/delete-driver/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverRepo.deleteById(id);
    }
    @DeleteMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable String id) {
        clientRepo.deleteById(id);
    }
    @GetMapping("/petition/drivers")
    public List<PetitionDrivers> getPetitionDrivers(){
        return petitionDriversRepo.findAll();
    }
    @GetMapping("/petition/clients")
    public List<PetitionClients> getPetitionClients(){
        return petitionClientsRepo.findAll();
    }

}
