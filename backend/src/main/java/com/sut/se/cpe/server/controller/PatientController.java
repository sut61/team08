package com.sut.se.cpe.server.controller;

import org.springframework.stereotype.Controller;
import com.sut.se.cpe.server.entity.Patient;
import com.sut.se.cpe.server.entity.Sex;
import com.sut.se.cpe.server.entity.Patienttype;
import com.sut.se.cpe.server.entity.Province;
import com.sut.se.cpe.server.entity.Doctor;
import com.sut.se.cpe.server.repository.PatientRepository;
import com.sut.se.cpe.server.repository.SexRepository;
import com.sut.se.cpe.server.repository.PatienttypeRepository;
import com.sut.se.cpe.server.repository.ProvinceRepository;
import com.sut.se.cpe.server.repository.DoctorRepository;
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
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private PatienttypeRepository patienttypeRepository;
    @Autowired
    private SexRepository sexRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctor/{doctorid}/{password}")
    public boolean doctor(@PathVariable String doctorid ,@PathVariable String password){
        Doctor doctor = doctorRepository.findByDoctorid(doctorid);
        String x = doctor.getPassword();
        System.out.println(doctorid);
        System.out.println(x + "=" + password);
        return x.matches(password);
    }

    @GetMapping(path = "provinces", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> Province() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/provinces/{id}")
    public Optional<Province> province(@PathVariable Long id) {
        Optional<Province> t = provinceRepository.findById(id);
        return t;
    }

    @GetMapping(path = "sexes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Sex> Sex() {
        return sexRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sexes/{id}")
    public Optional<Sex> sex(@PathVariable Long id) {
        Optional<Sex> a = sexRepository.findById(id);
        return a;
    }

    @GetMapping(path = "patienttypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Patienttype> Patienttype() {
        return patienttypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/patienttypes/{id}")
    public Optional<Patienttype> patienttype(@PathVariable Long id) {
        Optional<Patienttype> c = patienttypeRepository.findById(id);
        return c;
    }

    @PostMapping(path ="/Patient/{provinces}/{sexes}/{patienttypes}/{firstnameenter}/{lastnameenter}/{ages}/{district}/{subdistrict}/{housenumber}/{postcode}/{patientdetail}")
    public Patient patient( @PathVariable Long provinces,@PathVariable Long sexes,@PathVariable Long patienttypes,@PathVariable String firstnameenter,@PathVariable String lastnameenter,@PathVariable int ages,@PathVariable String district,@PathVariable String subdistrict,@PathVariable String housenumber,@PathVariable String postcode,@PathVariable String patientdetail){
        Province province = provinceRepository.findById(provinces).get();
        Sex sex = sexRepository.findById(sexes).get();
        Patienttype patienttype = patienttypeRepository.findById(patienttypes).get();

        Patient patient = new Patient();
        Date date = new Date();

        patient.setProvince(province);
        patient.setSex(sex);
        patient.setPatienttype(patienttype);
        patient.setFirstname(firstnameenter);
        patient.setLastname(lastnameenter);
        patient.setAge(ages);
        patient.setDistrict(district);
        patient.setSubdistrict(subdistrict);
        patient.setHousenumber(housenumber);
        patient.setPostcode(postcode);
        patient.setPatientdetail(patientdetail);
        patient.setDate(date);
        patientRepository.save(patient);
        return patient;
    }
}