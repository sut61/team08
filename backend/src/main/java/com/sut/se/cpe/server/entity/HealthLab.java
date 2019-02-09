package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class HealthLab {
    @Id
    @SequenceGenerator(name = "lab_seq", sequenceName = "lab_seq")
    @GeneratedValue(generator = "lab_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long sId;
    private @NonNull String sName;


}
