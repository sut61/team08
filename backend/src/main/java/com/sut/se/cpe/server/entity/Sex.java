package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Size(min=2,max=15)
    @Pattern(regexp="\\D+")
    private @NotNull String sex;
    @Size(min=2,max=15)
    @Pattern(regexp="\\D+")
    private @NotNull String nametitle;

    public Sex(){}
    public Sex(Long id){}
    public Long getid(){
        return id;
    }
}