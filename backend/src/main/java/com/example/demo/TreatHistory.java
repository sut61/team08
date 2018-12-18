package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class TreatHistory{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Symptom symptom;

    public TreatHistory(Doctor doctor, Patient patient, Symptom symptom){
        this.doctor = doctor;
        this.patient = patient;
        this.symptom = symptom;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setSymptom(Symptom symptom){
        this.symptom = symptom;
    }
    public Symptom getSymptom(){
        return symptom;
    }

}