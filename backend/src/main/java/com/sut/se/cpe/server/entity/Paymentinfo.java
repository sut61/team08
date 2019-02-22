package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;
import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Collection;

@Getter @Setter
@Entity
@Data
@Table(name = "Paymentinfo")
public class Paymentinfo {
    @Id
    @SequenceGenerator(name="Paymentinfo_seq",sequenceName="Paymentinfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Paymentinfo_seq")
    @Column(name="Paymentinfo_ID")


    private  Long PaymentinfoID;
    private String PayPrice;

    public Paymentinfo() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nurse_ID", insertable = true)
    private  Nurse nurse;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Payer_ID", insertable = true)
    private  Payer payer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "PaymentStatus_ID",insertable = true)
    private PaymentStatus paymentStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "PayType_ID",insertable = true)
    private PayType paytype;


    public void setPayPrice(String PayPrice){this.PayPrice=PayPrice;}
    public String getPayPrice(){return PayPrice;}
    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setNurse(Nurse nurse){this.nurse=nurse;}
    public Nurse getNurse() { return nurse; }
    public void setPayType(PayType paytype){this.paytype=paytype;}
    public PayType getPayType(){return paytype;}
    public void setPayer(Payer payer){this.payer=payer;}
    public Payer getPayer() { return payer; }



    public Paymentinfo(String PayPrice, Nurse nurse,Payer payer,  PayType paytype,PaymentStatus paymentStatus) {

        this.PayPrice=PayPrice;
        this.paymentStatus=paymentStatus;
        this.nurse=nurse;
        this.paytype=paytype;
        this.payer=payer;

    }
}

