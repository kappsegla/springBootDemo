package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.demo.controller.PlaygroundController;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.repository.PlaygroundRepository;
import com.example.demo.service.OrganizationService;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
@WebMvcTest(PlaygroundController.class)
//@WithMockUser(username = "test@test.nu", authorities = "SCOPE_test")
@AutoConfigureMockMvc(addFilters = false)
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PlaygroundRepository playgroundRepository;

	@Test
	public void getCarShouldReturnCarDetails() throws Exception {
    	when(playgroundRepository.findAll())
		.thenReturn(List.of());

    	mvc.perform(get("/playgrounds"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().json("[]"));
	}
}

