package sut.sa.g27.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class LabStaffPosition {
    @Id
    @SequenceGenerator(name = "labStaffPosition_seq", sequenceName = "labStaffPosition_seq")
    @GeneratedValue(generator = "labStaffPosition_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long labStaffPositId;
    private @NonNull String labStaffPositName;
}
