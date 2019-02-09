package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sut.se.cpe.server.entity.StaffPosition;
import com.sut.se.cpe.server.repository.StaffPositionRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffPositionController {
    @Autowired
    public StaffPositionRepository staffPositionRepository;

    @GetMapping("/StaffPosition")
    public List<StaffPosition> getStaffPosition(){
        return staffPositionRepository.findAll().stream().collect(Collectors.toList());
    }
}
