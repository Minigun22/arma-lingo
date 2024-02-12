package com.armalingo.armalingo.model;

import com.armalingo.armalingo.util.Rank;
import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private Rank rank;
}
