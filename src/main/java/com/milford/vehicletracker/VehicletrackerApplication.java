package com.milford.vehicletracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicletrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicletrackerApplication.class, args);
	}

	/* 
	@Bean
	CommandLineRunner commandLineRunner(GeocodeService geocodeService) {
		
		return args -> {
			geocodeService.reverseGeocode();


		
		}; 

	} */

}
