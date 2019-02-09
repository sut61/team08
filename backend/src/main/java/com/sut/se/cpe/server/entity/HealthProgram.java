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
public class HealthProgram {
    @Id
    @SequenceGenerator(name = "program_seq", sequenceName = "program_seq")
    @GeneratedValue(generator = "program_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long programId;
    private @NonNull String programName;
    private @NonNull String price;

}
