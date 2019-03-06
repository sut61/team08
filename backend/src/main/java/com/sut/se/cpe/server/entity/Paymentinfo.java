package com.sut.se.cpe.server.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;

@Getter @Setter
@Entity
@Data
@Table(name = "Paymentinfo")
public class Paymentinfo {
    @Id
    @SequenceGenerator(name="Paymentinfo_seq",sequenceName="Paymentinfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Paymentinfo_seq")
    @Column(name="Paymentinfo_ID")

    @NotNull
    private Long PaymentinfoID;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    @Size(min = 1, max = 5 )
    private String PayPrice;


    private @NotNull String Note;

    private @NotNull String MediList;

    private @NotNull String TreatList;

    private @NotNull String SpecialNote;







    public Paymentinfo() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nurse_ID", insertable = true)
    @NotNull
    private  Nurse nurse;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Payer_ID", insertable = true)
    @NotNull
    private  Payer payer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "PaymentStatus_ID",insertable = true)
    @NotNull
    private PaymentStatus paymentStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "PayType_ID",insertable = true)
    @NotNull
    private PayType paytype;


    public void setPayPrice(String PayPrice){this.PayPrice=PayPrice;}
    public String getPayPrice(){return PayPrice;}

    public void setNote(String Note){this.Note=Note;}
    public String getNote(){return Note;}

    public void setMediList(String MediList){this.MediList=MediList;}
    public String getMediList(){return MediList;}

    public void setTreatList(String TreatList){this.TreatList=TreatList;}
    public String getTreatList(){return TreatList;}

    public void setSpecialNote(String SpecialNote){this.SpecialNote=SpecialNote;}
    public String getSpecialNote(){return SpecialNote;}



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



    public Paymentinfo(String PayPrice, Nurse nurse,Payer payer,  PayType paytype,PaymentStatus paymentStatus,String Note,String TreatList,String MediList,String SpecialNote) {

        this.PayPrice=PayPrice;
        this.paymentStatus=paymentStatus;
        this.nurse=nurse;
        this.paytype=paytype;
        this.payer=payer;
        this.Note=Note;
        this.TreatList=TreatList;
        this.SpecialNote=SpecialNote;
        this.MediList=MediList;

    }
}

