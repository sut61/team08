package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.util.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
public class WorkSchedule {
    @Id
    @SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq")
    @GeneratedValue(generator = "schedule_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long scheduleId;

    private @NonNull Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sId")
    private HealthLab healthLab;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffPositId")
    private StaffPosition staffPosition;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workdayId")
    private Workday workday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worktimeId")
    private Worktime worktime;

}
