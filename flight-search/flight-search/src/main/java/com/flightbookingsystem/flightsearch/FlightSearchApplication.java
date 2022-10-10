package com.flightbookingsystem.flightsearch;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class FlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
	}
	
	@Bean
	public Docket SwaggerConfiguration() {
		//return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.flightbookingsystem.flightsearch"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
			"Flight Search API",
			"API for flight search",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Siddhi", "http://javabrains.io", "xyz@gmail.com"),
			"API Liscense",
			"http://javabrains.io",
			java.util.Collections.emptyList());
	}
}


