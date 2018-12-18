package com.example.demo;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Appointment")
@Data

public class Appointment {
    private @NonNull Long id;
}