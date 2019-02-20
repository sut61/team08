package com.sut.se.cpe.server.controller;

import com.sut.se.cpe.server.entity.Medi;

import com.sut.se.cpe.server.repository.MediRepository;

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
public class MediController {

    @Autowired
    private  MediRepository mediRepository;
    //private final OwnerRepository ownerRepository;

    public MediController(MediRepository ownerRepository) {
        this.mediRepository = ownerRepository;
    }
    @GetMapping(path = "Medi", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medi> Owner() {
        return mediRepository.findAll().stream().collect(Collectors.toList());
    } }