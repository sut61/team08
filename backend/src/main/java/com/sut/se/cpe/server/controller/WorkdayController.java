package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sut.se.cpe.server.entity.Workday;
import com.sut.se.cpe.server.repository.WorkdayRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WorkdayController {
    @Autowired
    public WorkdayRepository workdayRepository;

    @GetMapping("/Workday")
    public List<Workday> getWorkday(){
        return workdayRepository.findAll().stream().collect(Collectors.toList());
    }
}
