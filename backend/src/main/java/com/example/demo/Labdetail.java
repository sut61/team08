package com.example.demo;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name="Labdetail")
@Data

public class Labdetail {
    private @NonNull Long id;
}