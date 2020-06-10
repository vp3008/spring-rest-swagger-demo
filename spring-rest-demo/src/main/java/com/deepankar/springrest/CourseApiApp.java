package com.deepankar.springrest;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CourseApiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CourseApiApp.class, args);

	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.deepankar.springrest"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
					"Online Course API",
					"API for retrieving courses and topics",
					"1.1", 
					"Free to use", 
					new springfox.documentation.service.Contact("Deepankar Pathak", "www.abcdxyz.com", "vp3008@gmail.com"),
					"API License",
					"http://xyz.com",
					Collections.emptyList());
	}

}
