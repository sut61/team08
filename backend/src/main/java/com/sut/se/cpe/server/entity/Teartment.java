package com.sut.se.cpe.server.entity;
import javax.validation.constraints.*;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Teartment")
public class Teartment {
    @Id
    @SequenceGenerator(name="Teartment_seq",sequenceName="Teartment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Teartment_seq")
    @Column(name="Teartment")

    private  Long TeartmentID;


    private String Sytom;




    public Teartment() {}

    public Teartment (Long TeartmentID, String Sytom){
        this.Sytom = Sytom;

    }


    public void setSytom(String Sytom) {
        this.Sytom = Sytom;
    }
    public String getSytom() {
        return Sytom;
    }



}
