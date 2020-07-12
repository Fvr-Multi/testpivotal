package com.chainsys.carsaleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan("com.chainsys.carsaleapp.servlet")
public class CarsaleappApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarsaleappApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CarsaleappApplication.class, args);
	}

}
