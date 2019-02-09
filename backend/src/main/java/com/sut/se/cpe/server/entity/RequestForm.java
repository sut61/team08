package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import java.util.Date;

@Data
@Entity
@Getter @Setter
@Table(name = "RequestForm")
public class RequestForm{
    @Id
    @SequenceGenerator(name = "RequestForm_seq", sequenceName = "RequestForm_seq")
    @GeneratedValue(generator = "RequestForm_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private Date date;
    @NotNull
    private Integer amount;
    private String objective;
    @NotNull
    @Size(min = 5, max = 40)
    private String sgname;

    @ManyToOne
    private Approver approver;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Surrogate surrogate;
    @ManyToOne
    private Tool tool;

    public RequestForm(){}

    public RequestForm(Date date, Integer amount, String objective, String sgname, Approver approver, Department department,
                         Doctor doctor, Surrogate surrogate, Tool tool){
        this.date = date;
        this.amount = amount;
        this.objective = objective;
        this.sgname = sgname;
        this.approver = approver;
        this.department = department;
        this.doctor = doctor;
        this.surrogate = surrogate;
        this.tool = tool;
    }
    public Long getId() {
        return id;
    }
    public void setApprover(Approver approver){
        this.approver = approver;
    }
    public Approver getApprover(){
        return approver;
    }
    
    public void setDepartment(Department department){
        this.department = department;
    }
    public Department getDepartment(){
        return department;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return doctor;
    }

    public void setSurrogate(Surrogate surrogate){
        this.surrogate = surrogate;
    }
    public Surrogate getSurrogate(){
        return surrogate;
    }

    public void setTool(Tool tool){
        this.tool = tool;
    }
    public Tool getTool(){
        return tool;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    public Integer getAmount(){
        return amount;
    }

    public void setObjective(String objective){
        this.objective = objective;
    }
    public String getObejective(){
        return objective;
    }

    public void setSgname(String sgname){
        this.sgname = sgname;
    }
    public String getSgname(){
        return sgname;
    }


}