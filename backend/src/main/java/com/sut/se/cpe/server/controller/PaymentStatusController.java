package com.sut.se.cpe.server.controller;
import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
import lombok.Data;
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
public class PaymentStatusController {
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;


    @GetMapping(path = "PaymentStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PaymentStatus> Type() {  return paymentStatusRepository.findAll().stream().collect(Collectors.toList());
    }
}