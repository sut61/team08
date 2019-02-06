package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name="Onduty")
@Getter @Setter

public class Onduty {
    @Id
    @SequenceGenerator(name="ONDUTY_seq",sequenceName="ONDUTY_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ONDUTY_seq")
    @Column(name = "IdOnduty")


    private @NonNull Long id;
    private Date ondutydate;

    public Onduty(){}
    public Onduty(Long id){}
    public Long getid(){
        return id;
    }

    @ManyToOne
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Patienttype.class)
    @JoinColumn(name = "IdLab")
    private Lab lab;

    public void setLab(Lab lab){this.lab=lab;}
    public Lab getLab() { return lab; }

    public void setDoctor(Doctor doctor){this.doctor=doctor;}
    public Doctor getDoctor() { return doctor; }





    public Onduty(Doctor doctor,Lab lab){
        this.doctor = doctor;
        this.lab = lab;
    }
}