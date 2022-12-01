package com.example.demo.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.AgeService;


@WebMvcTest(OrganizationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class OrganizationControllerMVCTest {

    @MockBean
    OrganizationRepository orgrepo;
    @MockBean
    AgeService ageService;
    @MockBean
    MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void callingEndpointGetOrgsShouldReturn200OK() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get("/orgs"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
