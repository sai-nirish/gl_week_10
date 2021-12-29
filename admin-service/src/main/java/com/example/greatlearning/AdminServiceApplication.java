package com.example.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Start user service to start the h2 database server
@SpringBootApplication
public class AdminServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
