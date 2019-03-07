package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Workday {
    @Id
    @SequenceGenerator(name = "workday_seq", sequenceName = "workday_seq")
    @GeneratedValue(generator = "workday_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long workdayId;

    @NonNull private String daywork;

}
