package com.sut.se.cpe.server.controller;
import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
import org.springframework.http.MediaType;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentinfoController {
    @Autowired
    private PaymentinfoRepository paymentinfoRepository;
    @Autowired
    private NurseRepository nurseRepository ;
    @Autowired
    private PayTypeRepository  paytypeRepository;
    @Autowired
    private PayerRepository payerRepository;
    @Autowired
    private PaymentStatusRepository paymentstatusRepository;

    @GetMapping(path = "PaymentInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Paymentinfo> Paymentinfo() {
        return paymentinfoRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/PaymentInfo/{id}")
    public Optional<Paymentinfo> Paymentinfo(@PathVariable Long id)  {
        Optional<Paymentinfo> paymentinfo = paymentinfoRepository.findById(id);
        return paymentinfo;
    }



    @PostMapping(path ="/PaymentInfo/{PayTypeNameSelect}/{PayerNameSelect}/{NurseNameSelecte}/{PayPrice}/{PaymentStatusNameSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Paymentinfo Paymentinfo(
            @PathVariable  Long PayTypeNameSelect,
            @PathVariable  Long PayerNameSelect,
            @PathVariable  Long NurseNameSelecte,
            @PathVariable  String PayPrice,
            @PathVariable  Long PaymentStatusNameSelect

    ){
        PayType paytype = paytypeRepository.findById(PayTypeNameSelect).get();
        Payer payer = payerRepository.findById(PayerNameSelect).get();
        Nurse nurse = nurseRepository.findById(NurseNameSelecte).get();
        PaymentStatus paymentstatus = paymentstatusRepository.findById(PaymentStatusNameSelect).get();

        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayType(paytype);
        paymentinfo.setPayer(payer);
        paymentinfo.setNurse(nurse);
        paymentinfo.setPayPrice(PayPrice);
        paymentinfo.setPaymentStatus(paymentstatus);

        paymentinfoRepository.save(paymentinfo);
        return paymentinfo;
    }

}