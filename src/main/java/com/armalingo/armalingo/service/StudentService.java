package com.armalingo.armalingo.service;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.util.Roles;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public Student getReferenceById(Long id) {
        return  studentRepository.getReferenceById(id);
    }

    @Transactional
    public Student save(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole(Roles.ROLE_USER);
        return studentRepository.save(student);
    }

}
