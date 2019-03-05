package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

import javax.validation.constraints.*;

@Data
@Entity
@Table(name="Patient")
@Getter @Setter

@ToString
@EqualsAndHashCode
public class Patient {
    @Id
    @SequenceGenerator(name="REG_seq",sequenceName="REG_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REG_seq")
    @Column(name="IdReg")
    private Long id;

    @Size(min=2,max=20)
    @Pattern(regexp="\\D+")
    private @NotNull String firstname;

    @Size(min=2,max=20)
    @Pattern(regexp="\\D+")
    private @NotNull String lastname;

    private @NotNull int age;

    @Size(min=2,max=15)
    @Pattern(regexp="\\D+")
    private @NotNull String district;

    @Size(min=2,max=15)
    @Pattern(regexp="\\D+")
    private @NotNull String subdistrict;

    @Size(min=2,max=10)
    private @NotNull String housenumber;

    @Size(min=2,max=5)
    @Pattern(regexp="\\d+")
    private @NotNull String postcode;

    @Size(min=2,max=50)
    @Pattern(regexp="\\D+")
    private @NotNull String patientdetail;

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient(){}

    public Long getId() {
        return id;
    }

    @ManyToOne
    private Patienttype patienttype;

    @ManyToOne
    private Province province;

    @ManyToOne
    private Sex sex;

    public void setPatienttype(Patienttype patienttype){this.patienttype=patienttype;}
    public Patienttype getPatienttype() { return patienttype; }

    public void setProvince(Province province){this.province=province;}
    public Province getProvince() { return province; }

    public void setSex(Sex sex){this.sex=sex;}
    public Sex getSex() { return sex; }

    public Patient(Patienttype patienttype,Province province,Date date,Sex sex,String firstname,String lastname,int age,String district,String subdistrict,String housenumber,String postcode,String patientdetail) {
        this.patienttype=patienttype;
        this.province=province;
        this.date=date;
        this.sex=sex;
        this.firstname=firstname;
        this.lastname=lastname;
        this.age=age;
        this.district=district;
        this.subdistrict=subdistrict;
        this.housenumber=housenumber;
        this.postcode=postcode;
        this.patientdetail=patientdetail;
    }
}