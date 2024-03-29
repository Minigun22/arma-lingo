package com.armalingo.armalingo.controller;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        try {
            Student student = studentService.getReferenceById(id);
            return ResponseEntity.ok(student);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred while fetching student");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody Student updateStudent){
        Student existingStudent;
        try {
            existingStudent = studentService.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setPassword(updateStudent.getPassword());
        existingStudent.setSpecialty(updateStudent.getSpecialty());
        return ResponseEntity.ok(existingStudent);
    }

}
