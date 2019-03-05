package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter @Setter
@Entity
@Data
@Table(name = "Mediscript")
public class Mediscript {
    @Id
    @SequenceGenerator(name="Mediscript_seq",sequenceName="Mediscript_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Mediscript_seq")
    @Column(name="Mediscript_ID")

    @NotNull
    private  Long MediscriptID;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    @Size(min = 1, max = 5 )
    private String AmountMedi;


    public Mediscript() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Doctor_ID", insertable = true)
    @NotNull
    private  Doctor doctor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Medi_ID", insertable = true)
    @NotNull
    private  Medi medi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdCompany",insertable = true)
    @NotNull
    private Company company;


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
    public void setCompany(Company company){this.company=company;}
    public Company getCompany(){return company;}



    public Mediscript(String AmountMedi, Doctor doctor,  Company company,Medi medi) {

        this.AmountMedi=AmountMedi;
        this.medi=medi;
        this.doctor=doctor;

        this.company=company;



    }
}

