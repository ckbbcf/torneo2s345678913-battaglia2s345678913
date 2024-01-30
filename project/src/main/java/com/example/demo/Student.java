package com.example.demo;

import com.sun.jdi.PrimitiveValue;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

//  QUI VADO A DEFINIRE IL MODELLO DI STUDENT

// ANNOTAZIONE @Data mette dentro tutti i setter e costructure in automatico
// FATTO ANCHE PER LE CLASSI FIGLIE COME ADDRESS
@Data
// questo dico che deriva da un documento di mongodb -> PER LA MAPPATURA
@Document
public class Student {

    // annotazione gli dico che è id del DB
    @Id
    private String id;
    private String firstName;
    private String lastName;

    // creare un index in mongodb su email
    // se metto unique allora se esite un altro e-mail uguale ritorna errore
    // @Indexed(unique = true)
    @Indexed
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;


    public Student(String firstName, String lastName, String email, Gender gender, Address address, List<String> favouriteSubjects, BigDecimal totalSpentInBooks, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
