package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    OrganizationRepository orgrepo;

    public OrganizationController(OrganizationRepository orgrepo) {
        this.orgrepo = orgrepo;
    }

    @GetMapping("/orgs")
    public Organization addOrganization(){
        Organization organization = new Organization();
        organization.setName("Gulfuddens AIK");
        Member m1 = new Member();
        m1.setName("Martin");
        Member m2 = new Member();
        m2.setName("Kalle");
        organization.getMembers().add(m1);
        organization.getMembers().add(m2);

        return orgrepo.save(organization);
    }

}