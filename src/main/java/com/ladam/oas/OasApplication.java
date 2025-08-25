package com.ladam.oas;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing

@OpenAPIDefinition(
		info =@Info(
				title = "OAS REST APIs",
				description = "Online Application System REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Lackson",
						email = "lacksinho@gmail.com",
						url = "http://www.ladam.me"
						),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.ladam.me/licence"
						
						)
				
				),
		
		externalDocs = @ExternalDocumentation(
				
				description = "Online Application System REST APIs Documentation",
				url = "https://github.com/lacksinho/oas-backend-spring-boot"
				)
		)
public class OasApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OasApplication.class, args);
	}

}
