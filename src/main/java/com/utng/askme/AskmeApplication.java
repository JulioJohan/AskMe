package com.utng.askme;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.Generated;

@SpringBootApplication
public class AskmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskmeApplication.class, args);
	}
	
	@Generated
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
