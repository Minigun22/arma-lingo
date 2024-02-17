package com.armalingo.armalingo.service;

import com.armalingo.armalingo.model.Student;
import com.armalingo.armalingo.repository.StudentRepository;
import com.armalingo.armalingo.security.StudentDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentDetailsService implements UserDetailsService {

private final StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> customer = studentRepository.findByEmail(username);
        if(customer.isEmpty()){
            throw  new UsernameNotFoundException("Користувача з таким логинои не знайдено");
        }
        return new StudentDetails(customer.get());
    }
}
