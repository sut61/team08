package com.sut.se.cpe.server.controller;

import com.sut.se.cpe.server.entity.Medicaltechnique;

import com.sut.se.cpe.server.repository.MedicaltechniqueRepository;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MedicaltechniqueController {

    @Autowired
    private  MedicaltechniqueRepository medicaltechniqueRepository;
    //private final OwnerRepository ownerRepository;

    public MedicaltechniqueController(MedicaltechniqueRepository medicaltechniqueRepository) {
        this.medicaltechniqueRepository = medicaltechniqueRepository;
    }
//    @GetMapping(path = "Medicaltechnique", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Collection<Medicaltechnique> Medicaltechnique() {
//        return MedicaltechniqueRepository.findAll().stream().collect(Collectors.toList());
//    } 

}