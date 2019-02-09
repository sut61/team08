package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sut.se.cpe.server.entity.RequestSuggestion;
import com.sut.se.cpe.server.repository.RequestSuggestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RequestSuggestionController {
    @Autowired
    public RequestSuggestionRepository requestSuggestionRepository;

    @GetMapping("/Request-Suggestion")
    public List<RequestSuggestion> getRequestSuggestion(){
        return requestSuggestionRepository.findAll().stream().collect(Collectors.toList());
    }
}
