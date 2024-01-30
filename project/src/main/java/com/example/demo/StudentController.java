package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// definisce questa classe come uno che risponde HTTP richieste
@RestController
// definisco la path in cui fare la richiesta
@RequestMapping("api/v1/students")

// questo va a prendere e unisce tutti i costruttori, mi va a colmare studentService e lo inizializza
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // mi ritorna un json con i Student di ritorno
    // definisco il verbo che uso per connettere
    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }

    // corretto funziona così
    @GetMapping(path = "/prova")
    public String prova(){
        return "Ciao";
    }

}
