package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
@Entity
@ToString @EqualsAndHashCode
@Table(name="Sex")
@Data

public class Sex {
    @Id
    @SequenceGenerator(name="SEX_seq",sequenceName="SEX_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEX_seq")
    @Column(name = "IdSex")
    private @NonNull Long id;
    private String sex;
    private String nametitle;

    public Sex(){}
    public Sex(Long id){}
    public Long getid(){
        return id;
    }
}