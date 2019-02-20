package com.sut.se.cpe.server.controller;

import com.sut.se.cpe.server.entity.Doctor;
import com.sut.se.cpe.server.repository.DoctorRepository;

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
public class DoctorController {

    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @GetMapping(path = "Doctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    } }


