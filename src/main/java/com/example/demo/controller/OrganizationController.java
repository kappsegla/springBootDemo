package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.entity.Organization;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.repository.Proj;

import jakarta.transaction.Transactional;

@RestController
public class OrganizationController {

    OrganizationRepository orgrepo;
    MemberRepository memberRepository;

    public OrganizationController(OrganizationRepository orgrepo, MemberRepository memberRepository) {
        this.orgrepo = orgrepo;
        this.memberRepository = memberRepository;
    }

    // @GetMapping("/orgs")
    // public List<Proj> getAllOrganizationNames(){
    //     return orgrepo.findAllByNameAndId("Test", 1L);
    // }

    @GetMapping("/orgs")
    @Transactional
    public void getAllOrganizationNames(){
        orgrepo.addPrefixToName("#");
    }



    @GetMapping("/orgs/{name}")     
    public List<Organization> getAllOrganizationsByName(@PathVariable String name){
        return orgrepo.findOrganizationByMembersName(name);
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