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
@Table(name = "PaymentStatus")
public class PaymentStatus {
    @Id
    @SequenceGenerator(name="PaymentStatus_seq",sequenceName="PaymentStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PaymentStatus_seq")
    @Column(name="PaymentStatus")

    private  Long PaymentStatusID;
    private String PaymentStatusName;

    public PaymentStatus() {}
    public PaymentStatus(Long PaymentStatusID, String PaymentStatusName){
        this.PaymentStatusName = PaymentStatusName;

    }

    public void setPaymentStatusName(String PaymentStatusName) {
        this.PaymentStatusName = PaymentStatusName;
    }
    public String getPaymentStatusName() {
        return PaymentStatusName;
    }

}
