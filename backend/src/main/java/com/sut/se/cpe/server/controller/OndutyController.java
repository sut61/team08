package com.sut.se.cpe.server.controller;

import com.sut.se.cpe.server.entity.Doctor;
import com.sut.se.cpe.server.repository.DoctorRepository;
import com.sut.se.cpe.server.entity.Lab;
import com.sut.se.cpe.server.repository.LabRepository;
import com.sut.se.cpe.server.entity.Onduty;
import com.sut.se.cpe.server.repository.OndutyRepository;


import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OndutyController{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private OndutyRepository ondutyRepository;

    @GetMapping(path = "labs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Lab> Lab() {
        return labRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/labs/{id}")
    public Optional<Lab> lab(@PathVariable Long id) {
        Optional<Lab> a = labRepository.findById(id);
        return a;
    }

    @GetMapping(path = "/doctors")
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/doctors/{id}")
    public Optional<Doctor> doctor(@PathVariable Long id) {
        Optional<Doctor> d = doctorRepository.findById(id);
        return d;
    }

    @PostMapping(path ="onduty/{doctors}/{labs}/{dailyreport}/{sign}/{brokenreport}")
    public Onduty onduty(@PathVariable Long doctors,@PathVariable Long labs,@PathVariable String dailyreport,@PathVariable String sign,@PathVariable String brokenreport){
        Doctor doctor = doctorRepository.findById(doctors).get();
        Lab lab = labRepository.findById(labs).get();

        Onduty onduty = new Onduty();
        Date date = new Date();

        onduty.setDoctor(doctor);
        onduty.setLab(lab);
        onduty.setBrokenreport(brokenreport);
        onduty.setDailyreport(dailyreport);
        onduty.setSign(sign);
        onduty.setOndutydate(date);
        ondutyRepository.save(onduty);
        return onduty;
    }
}
