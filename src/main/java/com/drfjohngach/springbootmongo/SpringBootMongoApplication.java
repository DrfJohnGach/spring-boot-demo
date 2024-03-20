package com.drfjohngach.springbootmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address("England","London","NW9");
			Student student = new Student(
					"Jamilla",
					"Ahmed",
					"jamilla@gmail.com",
					Gender.FEMALE,
					address,
					List.of("Computer Science", "Math"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			repository.findStudentByEmail(student.getEmail())
					.ifPresentOrElse(s ->{
						System.out.println("User with that email already exists");
					}, () ->{
						System.out.println("New student created " + student.getFirstName());
						repository.insert(student);
					});
		};
	}
}
