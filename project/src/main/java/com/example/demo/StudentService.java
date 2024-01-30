package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
// inizilizza come parte business del server
@Service
public class StudentService {
    // questo fa da ponte tra router e DB

    // collegamento al DB per fare le query
    private final StudentRepository studentRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
