package com.armalingo.armalingo.controller;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class RegistrationController {

    private final StudentRepository studentRepository;

    @Autowired
    public RegistrationController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/registration")
    public ResponseEntity<Student> registerUser(@ModelAttribute("student") Student student){
        student.setRole(Roles.ROLE_USER);
        Student saveStudent = studentRepository.save(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveStudent.getId())
                .toUri());
        return new ResponseEntity<>(saveStudent, httpHeaders, HttpStatus.CREATED);
    }

}
