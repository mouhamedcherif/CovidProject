package com.esprit.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@ComponentScan(basePackages = "pl.hypeapp.episodie.configuration")
//@EnableJpaRepositories(basePackages = {"com.esprit.covid.repository"})
//@EntityScan(basePackages= {"com.esprit.covid.model"})
@EnableAutoConfiguration
@SpringBootApplication
public class Covid1Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid1Application.class, args);
	}

}
