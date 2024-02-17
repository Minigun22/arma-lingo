package com.armalingo.armalingo.controller;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.service.StudentService;
import com.armalingo.armalingo.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class RegistrationController {

    private final StudentService studentService;

    @Autowired
    public RegistrationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Student> registerUser(@ModelAttribute("student") Student student){
        Student saveStudent = studentService.save(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveStudent.getId())
                .toUri());
        return new ResponseEntity<>(saveStudent, httpHeaders, HttpStatus.CREATED);
    }
    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }

}
