package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AirportRepo airportRepo) {
		return args -> {
			var id = new AirportID();

			Optional<Airport> maybe_airport = airportRepo.findById(id);
			maybe_airport.ifPresentOrElse(
					(a) -> airportRepo.save(a),
					() -> {
						var airport = new Airport();
						airport.setCountryCode("SE");
						airport.setCityCode("GBG");
						airportRepo.save(airport);
					});
		};
	}

}
