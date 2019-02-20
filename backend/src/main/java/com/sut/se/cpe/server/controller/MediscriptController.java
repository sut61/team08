package com.sut.se.cpe.server.controller;
import lombok.Data;
import org.springframework.http.MediaType;
import com.sut.se.cpe.server.entity.*;

import com.sut.se.cpe.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MediscriptController {
    @Autowired
    private MediscriptRepository mediscriptRepository;
    @Autowired
    private DoctorRepository doctorRepository ;
    @Autowired
    private MediRepository  mediRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "Mediscript", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Mediscript> Mediscript() {
        return mediscriptRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Mediscript/{id}")
    public Optional<Mediscript> Mediscript(@PathVariable Long id)  {
        Optional<Mediscript> mediscript = mediscriptRepository.findById(id);
        return mediscript;
    }
    @PostMapping(path ="/Mediscript/{MediNameSelect}/{PatientNameSelect}/{DoctornameSelecte}/{amountMedi}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Mediscript Mediscript(
            @PathVariable  Long MediNameSelect,
            @PathVariable  Long PatientNameSelect,
            @PathVariable  Long DoctornameSelecte,
             @PathVariable  String amountMedi

    ){
        Medi medi = mediRepository.findById(MediNameSelect).get();
        Patient patient = patientRepository.findById(PatientNameSelect).get();
        Doctor doctor = doctorRepository.findById(DoctornameSelecte).get();

        Mediscript mediscript = new Mediscript();
        mediscript.setMedi(medi);
        mediscript.setPatient(patient);
        mediscript.setDoctor(doctor);
        mediscript.setAmountMedi(amountMedi);

        mediscriptRepository.save(mediscript);
        return mediscript;
    }

}