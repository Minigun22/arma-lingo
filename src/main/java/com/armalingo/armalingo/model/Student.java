package com.armalingo.armalingo.model;

import com.armalingo.armalingo.util.Rank;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "military_rank")
    private Rank rank;
}
