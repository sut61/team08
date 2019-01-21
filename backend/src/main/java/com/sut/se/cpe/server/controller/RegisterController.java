package com.sut.se.cpe.server.controller;

import org.springframework.stereotype.Controller;
import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
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