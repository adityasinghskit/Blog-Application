package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info=@Info(title="BlogApi",version="1.0",description="API for Blog websites that can perform CRUD operations"))
@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
	LocalValidatorFactoryBean lvfb=new LocalValidatorFactoryBean();
	lvfb.setValidationMessageSource(ms);
	return lvfb;
	}

}
