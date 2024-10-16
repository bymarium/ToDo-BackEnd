package com.example.task.appTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTaskApplication.class, args);
		System.out.println("Server is Running");
	}
}
