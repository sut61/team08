package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Register")
@Getter @Setter

@ToString
@EqualsAndHashCode
public class Register {
    @Id
    @SequenceGenerator(name="REG_seq",sequenceName="REG_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REG_seq")
    @Column(name="IdReg")
    private @NonNull Long id;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Register(){}

    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Patienttype.class)
    @JoinColumn(name = "IdPatienttype")
    private Patienttype patienttype;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Province.class)
    @JoinColumn(name = "IdProvince")
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Sex.class)
    @JoinColumn(name = "IdSex")
    private Sex sex;

    public void setPatienttype(Patienttype medinfo){this.patienttype=patienttype;}
    public Patienttype getPatienttype() { return patienttype; }

    public void setProvince(Province province){this.province=province;}
    public Province getProvince() { return province; }

    public void setSex(Sex sex){this.sex=sex;}
    public Sex getSex() { return sex; }

    public Register(Patienttype patienttype,Province province,Date date,Sex sex) {
        this.patienttype=patienttype;
        this.province=province;
        this.date=date;
        this.sex=sex;
    }
}