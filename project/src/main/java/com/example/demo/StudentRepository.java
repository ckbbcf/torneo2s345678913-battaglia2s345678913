package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

// quello che uso per fare le query verso mongodb collection Student
// in MongoRepository ho già dei metodi definiti per le query come findAll, ...
public interface StudentRepository extends MongoRepository<Student, String> {

    // costruzione di query specifiche in base al nome del metodo

    Optional<Student> findStudentByEmail(String emailStudent);
    // qui posso mettere direttamente le query in mongodb

    /*
    @Query("")
    void test();
     */
}
