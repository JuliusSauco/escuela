package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.util.CustomRepositoryimpl;

@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryimpl.class)
@SpringBootApplication
public class EscuelaProductoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaProductoMsApplication.class, args);
	}

}
