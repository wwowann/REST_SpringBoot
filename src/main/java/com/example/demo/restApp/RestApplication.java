package com.example.demo.restApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class RestApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(RestApplication.class, args);
	}

}
