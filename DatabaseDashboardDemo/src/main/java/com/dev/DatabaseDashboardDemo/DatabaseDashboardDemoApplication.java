package com.dev.DatabaseDashboardDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = "com.dev.DatabaseDashboardDemo.entity")
@EnableJpaRepositories(basePackages = "com.dev.DatabaseDashboardDemo.repositories")
public class DatabaseDashboardDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDashboardDemoApplication.class, args);
	}

}
