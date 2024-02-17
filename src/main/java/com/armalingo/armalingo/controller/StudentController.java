package com.armalingo.armalingo.controller;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.util.Roles;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("api/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("student", new Student());
        return "welcome/registration";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        try {
            Student student = studentRepository.getReferenceById(id);
            return ResponseEntity.ok(student);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred while fetching student");
        }
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

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody Student updateStudent){
        Student existingStudent;
        try {
            existingStudent = studentRepository.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setPassword(updateStudent.getPassword());
        existingStudent.setSpecialty(updateStudent.getSpecialty());
        return ResponseEntity.ok(existingStudent);
    }

}
