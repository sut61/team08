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
public class OrderlabController {
    @Autowired
    private OrderlabRepository orderlabRepository;
    @Autowired
    private DoctorRepository doctorRepository ;
    @Autowired
    private MedicaltechniqueRepository  medicaltechniqueRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "Orderlab", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Orderlab> Orderlab() {
        return orderlabRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/PatientSelectt")
    public Collection<Patient> Patient() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/DoctorSelectt")
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/MedicaltechniqueSelectt")
    public Collection<Medicaltechnique> Medicaltechnique() {
        return medicaltechniqueRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/Orderlab/{MedicaltechniqueSelectt}/{PatientSelectt}/{DoctorSelectt}/{ordername}/{note}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Orderlab Orderlab(
            @PathVariable  Long MedicaltechniqueSelectt,
            @PathVariable  Long PatientSelectt,
            @PathVariable  Long DoctorSelectt,
            @PathVariable  String ordername,
            @PathVariable String note

    ){
        Medicaltechnique medical = medicaltechniqueRepository.findById(MedicaltechniqueSelectt).get();
        Patient patie = patientRepository.findById(PatientSelectt).get();
        Doctor docxx = doctorRepository.findById(DoctorSelectt).get();


        Date date = new Date();
        Orderlab orderlab = new Orderlab();
        orderlab.setPatient(patie);
        orderlab.setDoctor(docxx);
        orderlab.setMedicaltechnique(medical);
        orderlab.setOrdername(ordername);
        orderlab.setNote(note);
        orderlab.setDate(date);

        orderlabRepository.save(orderlab);
        return orderlab;
    }

}