package com.sut.se.cpe.server.controller;

import org.springframework.stereotype.Controller;
import com.sut.se.cpe.server.entity.Register;
import com.sut.se.cpe.server.entity.Sex;
import com.sut.se.cpe.server.entity.Patienttype;
import com.sut.se.cpe.server.entity.Province;
import com.sut.se.cpe.server.repository.RegisterRepository;
import com.sut.se.cpe.server.repository.SexRepository;
import com.sut.se.cpe.server.repository.PatienttypeRepository;
import com.sut.se.cpe.server.repository.ProvinceRepository;
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
public class RegisterController {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private PatienttypeRepository patienttypeRepository;
    @Autowired
    private SexRepository sexRepository;


}