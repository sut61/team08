package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
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
    private @NotNull String sex;
    private @NotNull String nametitle;

    public Sex(){}
    public Sex(Long id){}
    public Long getid(){
        return id;
    }
}