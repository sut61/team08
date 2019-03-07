package com.sut.se.cpe.server.entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Workday {
    @Id
    @SequenceGenerator(name = "workday_seq", sequenceName = "workday_seq")
    @GeneratedValue(generator = "workday_seq", strategy = GenerationType.SEQUENCE)
    @NotNull private Long workdayId;

    @Column(unique = true)
    @NotNull private String daywork;

}
