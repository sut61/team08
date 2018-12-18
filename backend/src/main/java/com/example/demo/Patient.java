package com.example.demo;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Patient")
@Data

public class Patient {
    private @NonNull Long id;
}