package com.sut.se.cpe.server.controller;
import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PayerController {
    @Autowired
    private PayerRepository payerRepository;


    @GetMapping(path = "Payer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Payer> Type() {  return payerRepository.findAll().stream().collect(Collectors.toList());
    }
    }