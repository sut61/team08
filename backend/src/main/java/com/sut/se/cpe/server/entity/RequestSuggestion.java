package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class RequestSuggestion {
    @Id
    @SequenceGenerator(name = "request_seq", sequenceName = "request_seq")
    @GeneratedValue(generator = "request_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long requestSuggestionId;
    private @NonNull String userRequestName;
    private @NonNull String question;
    private @NonNull String email;

}
