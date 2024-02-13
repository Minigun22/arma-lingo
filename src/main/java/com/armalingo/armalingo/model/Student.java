package com.armalingo.armalingo.model;

import com.armalingo.armalingo.util.Specialty;
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

    @Column(name="user_name")
    private String login;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialty")
    private Specialty specialty;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
