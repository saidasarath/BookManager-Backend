package com.bookmanager.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class BookmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagerApplication.class, args);
	}

}
