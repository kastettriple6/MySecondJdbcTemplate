package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MySecondJdbcTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MySecondJdbcTemplateApplication.class, args);
	}

}
