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
public class RequestSuggestion {
    @Id
    @SequenceGenerator(name = "request_seq", sequenceName = "request_seq")
    @GeneratedValue(generator = "request_seq", strategy = GenerationType.SEQUENCE)
    
    @NotNull private Long requestSuggestionId;

    @Size(min = 5, max = 40)
    @NotNull private String userRequestName;

    @Size(max = 100)
    @NotNull private String question;

    @NotNull private String email;

}
