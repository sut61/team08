package com.sut.se.cpe.server.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String doctorname;
    private String doctorid;
    private String password;

    public Doctor(){}

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setDoctorname(String doctorname){
        this.doctorname = doctorname;
    }
    public String getDoctorname(){
        return doctorname;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setDoctorid(String doctorid){
        this.doctorid = doctorid;
    }
    public String getDoctorid(){
        return doctorid;
    }
    public void setDoctor(String doctorname){
        this.doctorname = doctorname;
    }
    public String getDoctor(){
        return doctorname;
    }
}

