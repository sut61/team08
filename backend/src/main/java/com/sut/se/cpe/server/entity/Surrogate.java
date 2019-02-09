package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@Table(name = "Surrogate")
public class Surrogate{
    @Id
    @SequenceGenerator(name = "Surrogate_seq", sequenceName = "Surrogate_seq")
    @GeneratedValue(generator = "Surrogate_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String surrogate;

    public Surrogate(){}

    public Surrogate(String surrogate){
        this.surrogate = surrogate;
    }
    public void setSurrogate(String surrogate){
        this.surrogate = surrogate;
    }
    public String getSurrogate(){
        return surrogate;
    }


}