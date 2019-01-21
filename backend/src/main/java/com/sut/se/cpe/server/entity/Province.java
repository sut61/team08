package com.sut.se.cpe.server.entity;
import lombok.*;
import javax.persistence.*;
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
    private @NonNull Long id;
    private String province;

    public Province(){}
    public Province(Long id){}
}