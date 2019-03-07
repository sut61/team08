package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sut.se.cpe.server.entity.Staff;
import com.sut.se.cpe.server.entity.WorkSchedule;
import com.sut.se.cpe.server.entity.HealthLab;
import com.sut.se.cpe.server.entity.StaffPosition;
import com.sut.se.cpe.server.entity.Workday;
import com.sut.se.cpe.server.entity.Worktime;
import com.sut.se.cpe.server.repository.StaffRepository;
import com.sut.se.cpe.server.repository.WorkScheduleRepository;
import com.sut.se.cpe.server.repository.HealthLabRepository;
import com.sut.se.cpe.server.repository.StaffPositionRepository;
import com.sut.se.cpe.server.repository.WorkdayRepository;
import com.sut.se.cpe.server.repository.WorktimeRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class WorkScheduleController {
    @Autowired
    public StaffPositionRepository staffPositionRepository;
    @Autowired
    public HealthLabRepository healthLabRepository;
    @Autowired
    public WorkScheduleRepository workScheduleRepository;
    @Autowired
    public StaffRepository staffRepository;
    @Autowired
    public WorkdayRepository workdayRepository;
    @Autowired
    public WorktimeRepository worktimeRepository;

    @GetMapping("/WorkSchedule")
    public List<WorkSchedule> getWorkSchedules(){
        return workScheduleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Register")
    public WorkSchedule newReg(@RequestBody WorkSchedule workSchedule){
        workSchedule.setDate(new Date());
        System.out.println("in newReg = " + workSchedule);
        return workScheduleRepository.save(workSchedule);
    }
}