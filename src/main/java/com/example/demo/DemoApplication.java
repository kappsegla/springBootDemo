package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.MemberRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MemberRepository repo) {
		return args -> {
			// var m = new Member();
			// m.setName("Kalle");
			// repo.save(m);
			//Put database code here to insert or update entities into repo
		};
	}

}
