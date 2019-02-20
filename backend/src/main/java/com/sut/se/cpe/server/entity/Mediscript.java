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
@Table(name = "Mediscript")
public class Mediscript {
    @Id
    @SequenceGenerator(name="Mediscript_seq",sequenceName="Mediscript_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Mediscript_seq")
    @Column(name="Mediscript_ID")


    private  Long MediscriptID;


    private String AmountMedi;


    public Mediscript() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Doctor_ID", insertable = true)
    private  Doctor doctor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Medi_ID", insertable = true)
    private  Medi medi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdPatient",insertable = true)
    private Patient patient;


    public void setAmountMedi(String AmountMedi){this.AmountMedi=AmountMedi;}
    public String getAmountMedi(){return AmountMedi;}
    public void setMedi(Medi medi){
        this.medi = medi;
    }
    public Medi getMedi() {
        return medi;
    }
    public void setDoctor(Doctor doctor){this.doctor=doctor;}
    public Doctor getDoctor() { return doctor; }
    public void setPatient(Patient patient){this.patient=patient;}
    public Patient getPatient(){return patient;}



    public Mediscript(String AmountMedi, Doctor doctor,  Patient patient,Medi medi) {

        this.AmountMedi=AmountMedi;
        this.medi=medi;
        this.doctor=doctor;

        this.patient=patient;



    }
}

