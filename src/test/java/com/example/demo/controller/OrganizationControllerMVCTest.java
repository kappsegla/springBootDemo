package com.example.demo.controller;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.entity.Organization;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.AgeService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        mockMvc.perform( get("/orgs"))
        .andExpect(status().isOk());
    }

    @Test
    void getOrganizationsShouldReturnListOfOrganizations() throws Exception{
        var org = new Organization();
        org.setName("Testorg");
        org.setId(1L);
        Mockito.when(orgrepo.findAll()).thenReturn(List.of(org));

        mockMvc.perform( get("/orgs"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].name").value("Testorg"))
        .andExpect(jsonPath("$[0].id").value("1"));
        


    }
}
