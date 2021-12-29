package com.example.greatlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Start user service before starting this service
@SpringBootApplication
@EnableFeignClients
public class OfflineUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfflineUserServiceApplication.class, args);
	}

}
