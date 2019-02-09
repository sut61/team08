package com.sut.se.cpe.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class StaffPosition {
    @Id
    @SequenceGenerator(name = "staffPosition_seq", sequenceName = "staffPosition_seq")
    @GeneratedValue(generator = "staffPosition_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long staffPositId;
    private @NonNull String staffPositName;
}
