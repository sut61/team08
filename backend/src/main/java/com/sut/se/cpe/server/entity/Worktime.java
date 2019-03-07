package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Worktime {
    @Id
    @SequenceGenerator(name = "worktime_seq", sequenceName = "worktime_seq")
    @GeneratedValue(generator = "worktime_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long worktimeId;

    @NonNull private String timework;
}
