package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Province")
@Data

public class Province {
    @Id
    @SequenceGenerator(name="PROVINCE_seq",sequenceName="PROVINCE_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROVINCE_seq")
    @Column(name = "IdProvince")
    private @NotNull Long id;

    @Size(min=2,max=20)
    @Pattern(regexp="\\D+")
    @Column(unique = true)
    private @NotNull String province;

    public Province(){}
    public Province(Long id){}
}