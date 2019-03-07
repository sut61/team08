package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;
import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Collection;

@Getter @Setter
@Entity
@Data
@Table(name = "Reportlab")
public class Reportlab {
    @Id
    @SequenceGenerator(name="Reportleb_seq",sequenceName="Reportlab_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Reportleb_seq")
    @Column(name="Reportleb_ID")


    private  Long ReportlabID;
    private String description;

    private String result_lab;
    private String nomal_range;
    private String other;


    public Reportlab() {
    }
    
    @ManyToOne
    private  Doctor doctor;

    @ManyToOne
    private Medicaltechnique medicaltechnique;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Department department;


    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    public void setResult_lab(String result_lab){
        this.result_lab = result_lab;
    }
    public String getResult_lab(){
        return result_lab;
    }

    public void setNomal_range(String nomal_range){
        this.nomal_range = nomal_range;
    }
    public String getNomal_range(){
        return nomal_range;
    }
    public void setOther(String other){
        this.other = other;
    }
    public String getOther(){
        return other;
    }


    public void setMedicaltechnique(Medicaltechnique medicaltechnique){
        this.medicaltechnique = medicaltechnique;
    }
    public Medicaltechnique getMedicaltechnique() {
        return medicaltechnique;
    }
    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    public Doctor getDoctor() {
        return doctor; 
    }
    public void setPatient(Patient patient){
        this.patient=patient;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
    public Department getDepartment(){
        return department;
    }



    public Reportlab(String description,String result_lab,String nomal_range,String other, Doctor doctor,  Patient patient, Medicaltechnique medicaltechnique,Department department) {

        this.description=description;
        this.result_lab = result_lab;
        this.nomal_range = nomal_range;
        this.other = other;
        this.doctor=doctor;
        this.patient=patient;
        this.medicaltechnique=medicaltechnique;
        this.department = department;

    }
}

