package com.armalingo.armalingo.controller;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/registration")
    public ResponseEntity<Student> registerUser(@RequestBody Student student){
        Student saveStudent = studentRepository.save(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveStudent.getId()).toUri());
        return new ResponseEntity<>(saveStudent, httpHeaders, HttpStatus.CREATED);
    }

}
