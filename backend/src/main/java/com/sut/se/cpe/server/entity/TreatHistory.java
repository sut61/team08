package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.Date;

@Entity
@Data
public class TreatHistory{
    @Id
    @GeneratedValue
    private Long id;

    private Integer pressure;
    private Integer weight;
    private String symptom;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date date;


    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Register register;
    @ManyToOne
    private Medicine medicine;

    public TreatHistory(){}

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public TreatHistory(Register register, Integer pressure, Integer weight, String symptom, Date date, Medicine medicine, Doctor doctor){
        this.pressure = pressure;
        this.weight = weight;
        this.symptom = symptom;
        this.doctor = doctor;
        this.register = register;
        this.medicine = medicine;
        this.date = date;
    }

    public void setPressure(Integer pressure){
        this.pressure = pressure;
    }
    public Integer getPressure(){
        return pressure;
    }
    public void setWeight(Integer weight){
       this.weight = weight; 
    }
    public Integer getWeight(){
        return weight;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public void setRegister(Register register){
        this.register = register;
    }
    public Register getRegister(){
        return register;
    }
    public void setMedicine(Medicine medicine){
        this.medicine = medicine;
    }
    public Medicine getMedicine(){
        return medicine;
    }
    public void setSymptom(String symptom){
        this.symptom = symptom;
    }
    public String getSymptom(){
        return symptom;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

}