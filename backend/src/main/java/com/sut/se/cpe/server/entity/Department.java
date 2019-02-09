package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@Table(name = "Department")
public class Department{
    @Id
    @SequenceGenerator(name = "Department_seq", sequenceName = "Department_seq")
    @GeneratedValue(generator = "Department_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String department;

    public Department(){}

    public Department(String department){
        this.department = department;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }


}