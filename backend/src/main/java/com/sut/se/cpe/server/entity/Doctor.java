package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    private String doctor;

    public Doctor(){}

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public Doctor(String doctor){
        this.doctor = doctor;
    }
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    public String getDoctor(){
        return doctor;
    }
}

