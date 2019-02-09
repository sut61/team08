package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sut.se.cpe.server.entity.HealthProgram;
import com.sut.se.cpe.server.repository.HealthProgramRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HealthProgramController {
    @Autowired
    public HealthProgramRepository healthProgramRepository;

    @GetMapping("/Health-Program")
    public List<HealthProgram> getHealthProgram(){
        return healthProgramRepository.findAll().stream().collect(Collectors.toList());
    }
}
