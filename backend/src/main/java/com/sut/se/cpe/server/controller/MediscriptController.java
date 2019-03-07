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
    private CompanyRepository companyRepository;

    @GetMapping(path = "Mediscript", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Mediscript> Mediscript() {
        return mediscriptRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/CompanyNameSelect")
    public Collection<Company> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/DoctorSelecte")
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/Mediscript/{MediNameSelect}/{CompanyNameSelect}/{DoctorSelecte}/{amountMedi}/{Note}/{PostPlace}/{PriceOrder}/{OrderPlace}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Mediscript Mediscript(
            @PathVariable  Long MediNameSelect,
            @PathVariable  Long CompanyNameSelect,
            @PathVariable  Long DoctorSelecte,
            @PathVariable  String amountMedi,
            @PathVariable  String Note,
            @PathVariable  String PostPlace,
            @PathVariable  String PriceOrder,
            @PathVariable  String OrderPlace


    ){
        Medi medi = mediRepository.findById(MediNameSelect).get();
        Company company = companyRepository.findById(CompanyNameSelect).get();
        Doctor doctorr = doctorRepository.findById(DoctorSelecte).get();

        Mediscript mediscript = new Mediscript();
        mediscript.setMedi(medi);
        mediscript.setCompany(company);
        mediscript.setDoctor(doctorr);
        mediscript.setAmountMedi(amountMedi);
        mediscript.setNote(Note);
        mediscript.setPostPlace(PostPlace);
        mediscript.setPriceOrder(PriceOrder);
        mediscript.setOrderPlace(OrderPlace);


        mediscriptRepository.save(mediscript);
        return mediscript;
    }

}