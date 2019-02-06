package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Lab")
@Data

public class Lab {
    @Id
    @SequenceGenerator(name="LAB_seq",sequenceName="LAB_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LAB_seq")
    @Column(name = "IdLab")
    private @NonNull Long id;

    @Size(min=2,max=5)
    @Pattern(regexp="\\d+")
    @Column(unique = true)
    private @NotNull String labid;
    private @NotNull String labaddress;

    public Lab(){}
    public Lab(Long id){}
    public Long getid(){
        return id;
    }
}