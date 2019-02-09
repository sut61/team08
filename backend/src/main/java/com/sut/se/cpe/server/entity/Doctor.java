package com.sut.se.cpe.server.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.*;

@Data
@Entity
@Getter @Setter
@Table(name = "Doctor")
public class Doctor {
    @Id
    @SequenceGenerator(name = "Doctor_seq", sequenceName = "Doctor_seq")
    @GeneratedValue(generator = "Doctor_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min=1,max=30)
    @Pattern(regexp="\\D+")
    private @NotNull String doctorname;
    private @NotNull String doctorid;
    private @NotNull String password;

    public Doctor(){}
    public Doctor(String doctorname, String password , String doctorid){
        this.doctorname = doctorname;
        this.password = password;
    }
    public void setDoctorname(String doctorname){
        this.doctorname = doctorname;
    }
    public String getDoctorname(){
        return doctorname;
    }
    public void setDoctorid(String doctorid){
        this.doctorid = doctorid;
    }
    public String getDoctorid(){
        return doctorid;
    }
}

