package com.archetana.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.archetana.xyz.repo.TheaterDBRepository")
public class TheatreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}

}
