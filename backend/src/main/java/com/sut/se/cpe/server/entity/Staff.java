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

@Data
@Entity
@NoArgsConstructor

public class Staff {
    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq")
    @GeneratedValue(generator = "staff_seq", strategy = GenerationType.SEQUENCE)
    @NotNull private Long staffId;
    
    @Size(min=6, max=30)
    @NotNull 
    private String staffName;

    @Column(unique = true)
    @Pattern(regexp = "[S]{1}[0-9]{5}+")
    @NotNull private String labStaffId;

    @Pattern(regexp = "[0]{1}[8-9]{1}[0-9]{8}+")
    @NotNull private String tel;

}