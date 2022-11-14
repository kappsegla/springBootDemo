package com.example.demo.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.entity.Organization;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;

@RestController
public class OrganizationController {

    OrganizationRepository orgrepo;
    MemberRepository memberRepository;

    public OrganizationController(OrganizationRepository orgrepo, MemberRepository memberRepository) {
        this.orgrepo = orgrepo;
        this.memberRepository = memberRepository;
    }


    @PostMapping("/orgs")
    public Organization addOrganization(@RequestBody Organization organization) {
        var m = Set.copyOf(organization.getMembers());
        organization.getMembers().clear();
        for (Member member : m) {
            if (member.getId() != null)
                organization.getMembers()
                        .add(
                                memberRepository.findById(member.getId())
                                        .orElse(member));
            else
                organization.getMembers()
                        .add(member);
        }

        return orgrepo.save(organization);

        // return orgrepo.findByName("Gulfuddens AIK");
        // return orgrepo.findOrganizationByMembersName("Martin");
    }

}