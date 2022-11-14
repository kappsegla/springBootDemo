package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    OrganizationRepository orgrepo;
    MemberRepository memberRepository;

    public OrganizationController(OrganizationRepository orgrepo, MemberRepository memberRepository) {
        this.orgrepo = orgrepo;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/orgs")
    public Organization addOrganization(){
        Organization organization = new Organization();
        organization.setName("Gulfuddens AIK");
        Member m1 = new Member();
        m1.setName("Martin");
        memberRepository.save(m1);
        Member m2 = new Member();
        m2.setName("Kalle");
        memberRepository.save(m2);
        organization.getMembers().add(m1);
        organization.getMembers().add(m2);

        return orgrepo.save(organization);
    }

}