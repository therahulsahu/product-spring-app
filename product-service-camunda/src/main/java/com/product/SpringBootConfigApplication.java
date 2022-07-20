package com.product;


import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.product"})
@EnableProcessApplication
public class SpringBootConfigApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class);
	}

}

