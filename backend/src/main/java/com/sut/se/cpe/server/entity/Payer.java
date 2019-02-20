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
@Table(name = "Payer")
public class Payer {
    @Id
    @SequenceGenerator(name="Payer_seq",sequenceName="Payer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Payer_seq")
    @Column(name="Payer")

    private  Long PayerID;


    private String PayerName;




    public Payer() {}

    public Payer (Long PayerID, String PayerName){
        this.PayerName = PayerName;

    }


    public void setPayerName(String PayerName) {
        this.PayerName = PayerName;
    }
    public String getPayerName() {
        return PayerName;
    }



}
