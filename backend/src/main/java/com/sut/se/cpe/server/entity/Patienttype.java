package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
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
    private @NonNull Long id;
    private String type;
    private String detail;

    public Long getid(){
        return id;
    }
    public Patienttype(){}
    public Patienttype(Long id){}
}