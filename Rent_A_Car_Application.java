package com.rent_a_car.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"com/rent_a_car/backend/Entity"})
public class Rent_A_Car_Application {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(Rent_A_Car_Application.class, args);
	}
}
