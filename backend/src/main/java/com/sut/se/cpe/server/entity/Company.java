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
@Table(name = "Company")
public class Company {
    @Id
    @SequenceGenerator(name="Company_seq",sequenceName="Company_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Company_seq")
    @Column(name="Company")

    private  Long CompanyID;

    private String CompanyName;

    public Company() {}
    public Company(Long CompanyID, String CompanyName){
        this.CompanyName = CompanyName;

    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }
    public String getCompanyName() {
        return CompanyName;
    }

}
