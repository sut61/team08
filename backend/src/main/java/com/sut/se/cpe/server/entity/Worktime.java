package com.sut.se.cpe.server.entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Worktime {
    @Id
    @SequenceGenerator(name = "worktime_seq", sequenceName = "worktime_seq")
    @GeneratedValue(generator = "worktime_seq", strategy = GenerationType.SEQUENCE)
    @NotNull private Long worktimeId;

    @Column(unique = true)
    @NotNull private String timework;
}
