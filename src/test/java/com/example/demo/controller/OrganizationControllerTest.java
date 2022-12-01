package com.example.demo.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

import com.example.demo.entity.Organization;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.AgeService;

@ExtendWith(MockitoExtension.class)
public class OrganizationControllerTest {

    //This test tests our controller method as a java method, ignoring routing information and json serialization...
    @Mock
    OrganizationRepository orgrepo;
    @Mock
    AgeService ageService;
    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    OrganizationController controller;

    @BeforeEach
    void configureOrgRepo() {
        Organization org = new Organization();
        org.setName("Programming inc");
        Mockito.when(orgrepo.findAll()).thenReturn(List.of(org));
    }

    @Test
    void getAllOrganizationNamesShouldReturnOrganizations() {
        var result = controller.getAllOrganizationNames();

        assertThat(result).hasSize(1);
    }
}
