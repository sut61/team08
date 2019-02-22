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
@Table(name = "PayType")
public class PayType {
    @Id
    @SequenceGenerator(name="PayType_seq",sequenceName="PayType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PayType_seq")
    @Column(name="PayType")

    private  Long PayTypeID;
    private String PayTypeName;

    public PayType() {}
    public PayType(Long PayTypeID, String PayTypeName){
        this.PayTypeName = PayTypeName;

    }

    public void setPayTypeName(String PayTypeName) {
        this.PayTypeName = PayTypeName;
    }
    public String getPayTypeName() {
        return PayTypeName;
    }

}
