package com.user.api;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.user.api.service.EmailService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class UserrApplication { 
	
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(UserrApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		/*
		emailService.sendSimpleEmail("anushka.gawade.it.2019@vpkbiet.org",
				 					 "Welcome to Flight Booking System!",
									 "Hola!");
		*/
		
		/*
		emailService.sendEmailWithAttachment("anushka.gawade.it.2019@vpkbiet.org",
											 "This is email body.",
											 "This is email has attachment.",
				 					 		 "F:\\PHOTOS\\OTHERS\\9ae7177eeea240410fb10109d2fdd772.jpg");
		*/

	}
	
	@Bean
	public Docket SwaggerConfiguration() {
		//return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.user.api"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
			"User API",
			"Sample API",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Anushka Gawade", "http://javabrains.io", "anushkagawade777@gmail.com"),
			"API Liscense",
			"http://javabrains.io",
			java.util.Collections.emptyList());
	}
	
}
