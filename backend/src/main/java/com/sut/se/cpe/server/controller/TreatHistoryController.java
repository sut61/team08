package com.sut.se.cpe.server.controller;

import com.sut.se.cpe.server.entity.TreatHistory;
import com.sut.se.cpe.server.entity.Patient;
import com.sut.se.cpe.server.entity.Doctor;
import com.sut.se.cpe.server.entity.Medicine;
import com.sut.se.cpe.server.repository.DoctorRepository;
import com.sut.se.cpe.server.repository.MedicineRepository;
import com.sut.se.cpe.server.repository.PatientRepository;
import com.sut.se.cpe.server.repository.TreatHistoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TreatHistoryController{
    @Autowired
    private TreatHistoryRepository treatHistoryRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MedicineRepository medicineRepository;

//    @GetMapping(path = "/doctor")
//    public Collection<Doctor> Doctor() {
//        return doctorRepository.findAll().stream().collect(Collectors.toList());
//    }
//
//    @GetMapping(path = "/doctor/{id}")
//    public Optional<Doctor> doctor(@PathVariable Long id) {
//        Optional<Doctor> d = doctorRepository.findById(id);
//        return d;
//    }


    @GetMapping(path = "/medicine")
    public Collection<Medicine> Medicine(){
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/treathistory")
    public Collection<TreatHistory> treatHistory(){
        return treatHistoryRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/treathistory/{patient}/{pressure}/{weight}/{symptom}/{date}/{medicine}/{doctor}")
    public TreatHistory treatHistory(@PathVariable Long patient, @PathVariable int pressure, @PathVariable int weight, @PathVariable String symptom,
                                     @PathVariable Date date, @PathVariable Long medicine, @PathVariable Long doctor){

        TreatHistory th = new TreatHistory();
        th.setPressure(pressure);
        th.setWeight(weight);
        th.setSymptom(symptom);
        th.setDate(date);
        Patient pat = patientRepository.findById(patient).get();
        Doctor doc = doctorRepository.findById(doctor).get();
        Medicine med = medicineRepository.findById(medicine).get();
        th.setPatient(pat);
        th.setDoctor(doc);
        th.setMedicine(med);
        treatHistoryRepository.save(th);
        return th;
    }
}