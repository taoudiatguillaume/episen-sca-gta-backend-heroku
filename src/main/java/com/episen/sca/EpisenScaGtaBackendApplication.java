package com.episen.sca;

import com.episen.sca.model.Student;
import com.episen.sca.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EpisenScaGtaBackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(EpisenScaGtaBackendApplication.class, args);
	}
}
