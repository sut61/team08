package com.sut.se.cpe.server.controller;


import com.example.demo.entity.Approver;
import com.example.demo.entity.Department;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Surrogate;
import com.example.demo.entity.Tool;
import com.example.demo.entity.RequestForm;
import com.example.demo.repository.ApproverRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.RequestFormRepository;
import com.example.demo.repository.SurrogateRepository;
import com.example.demo.repository.ToolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RequestFormController{
    @Autowired
    private ApproverRepository approverRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private RequestFormRepository requestformRepository;
    @Autowired
    private SurrogateRepository surrogateRepository;
    @Autowired 
    private ToolRepository toolRepository;

    @GetMapping(path = "/approver")
    public List<Approver> getApprover() {
        return approverRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/department")
    public Collection<Department> Department() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/doctor")
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/requestform")
    public Collection<RequestForm> RequestForm() {
        return requestformRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/surrogate")
    public Collection<Surrogate> Surrogate() {
        return surrogateRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/tool")
    public Collection<Tool> Tool() {
        return toolRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/requestform/{department}/{tool}/{amount}/{date}/{objective}/{surrogate}/{sgname}/{doctor}/{approver}")
    public RequestForm requestform(@PathVariable Long approver, @PathVariable Long department, @PathVariable Long doctor,@PathVariable Long surrogate,
                             @PathVariable Long tool, @PathVariable Date date, @PathVariable Integer amount, @PathVariable String objective, @PathVariable String sgname ) {
        RequestForm rf = new RequestForm();
        rf.setDate(date);
        rf.setAmount(amount);
        rf.setObjective(objective);
        rf.setSgname(sgname);
        Approver app = approverRepository.findById(approver).get();
        Department dep = departmentRepository.findById(department).get();
        Doctor doc = doctorRepository.findById(doctor).get();
        Surrogate sur = surrogateRepository.findById(surrogate).get();
        Tool tl = toolRepository.findById(tool).get();
        rf.setApprover(app);
        rf.setDepartment(dep);
        rf.setDoctor(doc);
        rf.setSurrogate(sur);
        rf.setTool(tl);
        requestformRepository.save(rf);
        return rf;
    }
    
    
    




}