package com.examly.parking.allotment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.examly.parking.allotment.controller" })
@EntityScan({"com.examly.parking.allotment.model"})
@EnableJpaRepositories({"com.examly.parking.allotment.dao"})
public class ParkingAllotmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingAllotmentApplication.class, args);
	}

}
