package com.promineotech.pet.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Runs the Spring Boot application and connects to the MySQL database called "pet_store"
@SpringBootApplication
public class PetStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

}
