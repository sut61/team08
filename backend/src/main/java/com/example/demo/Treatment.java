package com.example.demo;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Treatment")
@Data

public class Treatment {
    private @NonNull Long id;
}