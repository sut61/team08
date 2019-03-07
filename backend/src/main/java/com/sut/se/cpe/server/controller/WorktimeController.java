package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sut.se.cpe.server.entity.Worktime;
import com.sut.se.cpe.server.repository.WorktimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WorktimeController {
    @Autowired
    public WorktimeRepository worktimeRepository;

    @GetMapping("/Worktime")
    public List<Worktime> getWorktime(){
        return worktimeRepository.findAll().stream().collect(Collectors.toList());
    }
}
