package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.util.CustomRepositoryimpl;

@EnableDiscoveryClient
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryimpl.class)
@SpringBootApplication
public class EscuelaStockMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaStockMsApplication.class, args);
	}

}
