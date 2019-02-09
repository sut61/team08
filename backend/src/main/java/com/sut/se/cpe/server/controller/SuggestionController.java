package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sut.se.cpe.server.entity.Personnel;
import com.sut.se.cpe.server.entity.Suggestion;
import com.sut.se.cpe.server.entity.HealthProgram;
import com.sut.se.cpe.server.entity.RequestSuggestion;
import com.sut.se.cpe.server.repository.PersonnelRepository;
import com.sut.se.cpe.server.repository.SuggestionRepository;
import com.sut.se.cpe.server.repository.HealthProgramRepository;
import com.sut.se.cpe.server.repository.RequestSuggestionRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SuggestionController {
    @Autowired
    public RequestSuggestionRepository requestSuggestionRepository;
    @Autowired
    public HealthProgramRepository healthProgramRepository;
    @Autowired
    public SuggestionRepository suggestionRepository;
    @Autowired
    public PersonnelRepository personnelRepository;

    @GetMapping("/Suggestion")
    public List<Suggestion> getSuggestions(){
        return suggestionRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Direction")
    public Suggestion newGuide(@RequestBody Suggestion suggestion){
        suggestion.setDate(new Date());
        System.out.println("in newGuide = " + suggestion);
        return suggestionRepository.save(suggestion);
    }
}