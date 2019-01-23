package com.sut.se.cpe.server.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class Medicine{
    @Id
    @GeneratedValue
    private Long id;

    private String medicine;
    public Medicine(){}
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public Medicine(String medicine){
        this.medicine = medicine;
    }

    public void setMedicine(String medicine){
        this.medicine = medicine;
    }
    public String getMedicine(){
        return medicine;
    }



}