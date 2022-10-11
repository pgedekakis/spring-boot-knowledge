package com.postgre.empl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.postgre.empl.repository")
@EntityScan(basePackages = { "com.postgre.empl.model"})
public class EmplApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmplApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
