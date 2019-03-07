package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import javax.validation.*;


@Entity
@Data
@NoArgsConstructor

public class Personnel {
    @Id
    @SequenceGenerator(name = "personnel_seq", sequenceName = "personnel_seq")
    @GeneratedValue(generator = "personnel_seq", strategy = GenerationType.SEQUENCE)

    @NotNull
    private Long personnelId;
    
    @Size(min=5, max=40)
    @NotNull
    private String personnelName;
    
    @Pattern(regexp = "[P]{1}[0-9]+")
    @Size(min = 8, max = 8)
    @NotNull
    private String labPersonnelId;

    @NotNull
    private String guidanced;

}