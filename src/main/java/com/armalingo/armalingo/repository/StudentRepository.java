package com.armalingo.armalingo.repository;

import com.armalingo.armalingo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}