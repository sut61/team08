package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Patienttype")
@Data

public class Patienttype {
    @Id
    @SequenceGenerator(name="PATIENTTYPE_seq",sequenceName="PATIENTTYPE_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENTTYPE_seq")
    @Column(name = "IdPatienttype")
    private @NotNull Long id;
    private @NotNull String type;
    private @NotNull String detail;

    public Long getid(){
        return id;
    }
    public Patienttype(){}
    public Patienttype(Long id){}
}