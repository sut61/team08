package com.example.demo.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@Table(name = "Approver")
public class Approver{
    @Id
    @SequenceGenerator(name = "Approver_seq", sequenceName = "Approver_seq")
    @GeneratedValue(generator = "Approver_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String approver;

    public Approver(){}
    public Approver(Long id){}
    public Approver(String approver){
        this.approver = approver;
    }
    public Long getid(){
        return id;
    }
    public void setApprover(String approver){
        this.approver = approver;
    }
    public String getApprover(){
        return approver;
    }
}
