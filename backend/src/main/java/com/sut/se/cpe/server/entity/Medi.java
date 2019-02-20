package com.sut.se.cpe.server.entity;
import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Data
@Table(name = "Medi")
public class Medi {
    @Id
    @SequenceGenerator(name="Medi_seq",sequenceName="Medi_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Medi_seq")
    @Column(name="Medi_ID")
    @NotNull
    private  Long MediID;
   private String MediName;





    public void setMedi(Long MediID,String MediName){
        this.MediName=MediName;
    }
    public String getMedi(){return MediName; }
    
    public Medi() {}
    public Medi( String MediName) {
        this.MediName=MediName;



    }
}