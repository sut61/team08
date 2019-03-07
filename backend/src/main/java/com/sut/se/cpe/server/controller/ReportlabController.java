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
public class ReportlabController {
    @Autowired
    private ReportlabRepository reportlabRepository;
    @Autowired
    private DoctorRepository doctorRepository ;
    @Autowired
    private MedicaltechniqueRepository  medicaltechniqueRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(path = "Reportlab", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Reportlab> Reportlab() {
        return reportlabRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/PatientSelec")
    public Collection<Patient> Patient() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/DoctorSelec")
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/MedicaltechniqueSelec")
    public Collection<Medicaltechnique> Medicaltechnique() {
        return medicaltechniqueRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping(path = "/DepartmentSelec")
    public Collection<Department> Department() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/Reportlab/{MedicaltechniqueSelec}/{PatientSelec}/{DoctorSelec}/{DepartmentSelec}/{description}/{result_lab}/{nomal_range}/{other}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Reportlab reportlab(
            @PathVariable  Long MedicaltechniqueSelec,
            @PathVariable  Long PatientSelec,
            @PathVariable  Long DoctorSelec,
            @PathVariable  Long DepartmentSelec,
            @PathVariable  String description,
            @PathVariable String result_lab,
            @PathVariable String nomal_range,
            @PathVariable String other

    ){
        Medicaltechnique medical = medicaltechniqueRepository.findById(MedicaltechniqueSelec).get();
        Patient patie = patientRepository.findById(PatientSelec).get();
        Doctor docxx = doctorRepository.findById(DoctorSelec).get();
        Department depart = departmentRepository.findById(DepartmentSelec).get();


        
        Reportlab report = new Reportlab();
        report.setPatient(patie);
        report.setDoctor(docxx);
        report.setMedicaltechnique(medical);
        report.setDepartment(depart);
        report.setDescription(description);
        report.setResult_lab(result_lab);
        report.setNomal_range(nomal_range);
        report.setOther(other);
        

        reportlabRepository.save(report);
        return report;
    }

}