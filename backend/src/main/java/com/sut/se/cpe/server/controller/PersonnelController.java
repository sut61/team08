package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sut.se.cpe.server.entity.Personnel;
import com.sut.se.cpe.server.repository.PersonnelRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PersonnelController {
    @Autowired
    public PersonnelRepository personnelRepository;

    @PostMapping("/Personnel")
    public Personnel newPersonnel(@RequestBody Personnel personnel){
        System.out.println("this result = " + personnel);
        return  personnelRepository.save(personnel);
    }

    @GetMapping("/Personnel")
    public List<Personnel> getPersonnel(){
        return personnelRepository.findAll().stream().collect(Collectors.toList());
    }
}
