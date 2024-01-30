package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// è tipo un factory per creare dati internamente
	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address(
					"Italia",
					"Piacenza",
					"29122"
			);
			Student student = new Student(
					"miki",
					"bersa",
					"miisfs@sdfs",
					Gender.MALE,
					address,
					List.of("Computer Sciecne"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			String email = "miisfs@sdfs";

			/*
			// uso per fare una mia query
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));
			List<Student> students = monogoTemplateQuery.find(query, Student.class);

			if(students.size() > 1){
				throw new IllegalStateException("found many students with email "+email);
			}

			if(students.isEmpty()){
				System.out.println("inserting student "+student);
				repository.insert(student);
			}else {
				System.out.println(student + " already exists");
			}*/

			repository.findStudentByEmail(email).ifPresentOrElse(
					s -> {
						System.out.println("Already exists: "+ s);
					},
					() -> {
						System.out.println("Inserting student "+ student);
						repository.insert(student);
					}
			);
		};
	}
}
