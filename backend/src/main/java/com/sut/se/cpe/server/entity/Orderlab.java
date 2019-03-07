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
@Table(name = "Orderlab")
public class Orderlab {
    @Id
    @SequenceGenerator(name="Orderleb_seq",sequenceName="Orderlab_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Orderleb_seq")
    @Column(name="Orderleb_ID")


    private  Long OrderlabID;
    private String ordername;

    private String note;
    private Date date;


    public Orderlab() {
    }
    
    @ManyToOne
    private  Doctor doctor;

    @ManyToOne
    private Medicaltechnique medicaltechnique;

    @ManyToOne
    private Patient patient;


    public void setOrdername(String ordername){
        this.ordername = ordername;
    }
    public String getOrdername(){
        return ordername;
    }

    public void setNote(String note){
        this.note = note;
    }
    public String getNote(){
        return note;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
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



    public Orderlab(String ordername,String note,Date date, Doctor doctor,  Patient patient, Medicaltechnique medicaltechnique) {

        this.ordername=ordername;
        this.note = note;
        this.date = date;
        this.doctor=doctor;
        this.patient=patient;
        this.medicaltechnique=medicaltechnique;

    }
}

