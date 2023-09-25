package ru.olesya.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.olesya.pro.exceptions.UserExistException;
import ru.olesya.pro.model.Client;
import ru.olesya.pro.repo.ClientRepo;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin()
public class AuthController {
    @Autowired
    private ClientRepo clientRepo;
    @PostMapping("/register")
    public void addClient(@RequestBody Client client){
        if(clientRepo.findById(client.getId()).isPresent()){
            throw new UserExistException("Номер занят!");
        }
        clientRepo.save(client);
    }
    @PostMapping("/login")
    public ResponseEntity<?> logClient(@RequestBody Client client){
        Client test = clientRepo.findByIdAndPassword(client.getId(), client.getPassword());
        if(test==null){
            throw new UserExistException("Неправильный номер или пароль");
        }else{
            if (test.getId()=="54321"){
                return ResponseEntity.ok(new Client("admin", "",""));
            }
            return ResponseEntity.ok(test);
        }
    }

}
