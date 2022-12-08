package com.example.demo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	//https://www.baeldung.com/junit-filtering-tests

	@Test
	@Tag("Smoke")
	public void getCarShouldReturnCarDetails() {
		webTestClient.get().uri("/orgs")
		.exchange()
		.expectStatus().isUnauthorized();
	}
}
