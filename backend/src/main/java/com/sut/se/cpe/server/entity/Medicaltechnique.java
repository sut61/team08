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
@Table(name = "Medicaltechnique")
public class Medicaltechnique {
    @Id
    @SequenceGenerator(name="Medicaltechnique_seq",sequenceName="Medicaltechnique_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Medicaltechnique_seq")
    @Column(name="Medicaltechnique_ID")
    @NotNull
    private  Long MedicaltechniqueID;

    @NotNull private String Mtname;

    @NotNull private String Phonenumber;


    public void setMedicaltechnique(Long MedicaltechniqueID,String Mtname, String Phonenumber){
        this.Mtname=Mtname;
        this.Phonenumber = Phonenumber;
    }
    public void setMtname(String Mtname){
        this.Mtname = Mtname;
    }
    public String getMtname(){
        return Mtname;
    }
    public String getMedicaltechnique(){
        return Mtname; 
    }
    public void setPhonenumber(String Phonenumber){

        this.Phonenumber = Phonenumber;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }
    
    public Medicaltechnique() {}

    public Medicaltechnique( String MtName, String Phonenumber) {
        this.Mtname=Mtname;
        this.Phonenumber=Phonenumber;



    }
}