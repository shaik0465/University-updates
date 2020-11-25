package com.optumuniversity.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.optumuniversity.*")
public class UniversityUpdatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityUpdatesApplication.class, args);
	}

}
