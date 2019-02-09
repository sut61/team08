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
public class Suggestion {
    @Id
    @SequenceGenerator(name = "suggest_seq", sequenceName = "suggest_seq")
    @GeneratedValue(generator = "suggest_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long suggestionId;
    private @NonNull Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programId",insertable = true)
    private HealthProgram healthProgram;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requestSuggestionId",insertable = true)
    private RequestSuggestion requestSuggestion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personnelId",insertable = true)
    private Personnel personnel;

}
