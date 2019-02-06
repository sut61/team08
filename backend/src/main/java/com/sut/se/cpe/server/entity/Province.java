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
    private @NotNull String province;

    public Province(){}
    public Province(Long id){}
}