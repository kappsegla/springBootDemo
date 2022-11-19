package com.example.demo.controller;

import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Organization;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.AgeService;

@RestController
public class OrganizationController {

    Logger logger = LogManager.getLogger(OrganizationController.class);

    OrganizationRepository orgrepo;
    MemberRepository memberRepository;
    AgeService ageService;

    public OrganizationController(AgeService ageService, OrganizationRepository orgrepo, MemberRepository memberRepository) {
        this.ageService = ageService;
        this.orgrepo = orgrepo;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/orgs/{id}")
    // @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found
    // on the server")
    public ResponseEntity<Organization> getOne(@PathVariable("id") Long id) {
        var org = orgrepo.findById(id);
        logger.info("After loading Org from database");        
        if (org.isPresent())
            return ResponseEntity.ok().body(org.get());

        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status will be
        // NOT FOUND (CODE 404)\n");
        // return ResponseEntity.notFound().build();

        throw new CustomException("Stay in Bed Day, 20th of Nov");

    }

    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
        if (ageService.isInFuture(yearOfBirth)) {
            return ResponseEntity.badRequest()
                    .body("Year of birth cannot be in the future");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is " + ageService.calculateAge(yearOfBirth));
    }

    @PostMapping("/orgs")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {

        var myOrg = orgrepo.save(organization);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(myOrg.getId())
                .toUri();

        return ResponseEntity.created(location).body(myOrg);
    }

    // @GetMapping("/orgs")
    // @Transactional
    // public void getAllOrganizationNames(){
    // orgrepo.addPrefixToName("#");
    // }

    // @GetMapping("/orgs/{name}")
    // public List<Organization> getAllOrganizationsByName(@PathVariable String
    // name){
    // return orgrepo.findOrganizationByMembersName(name);
    // }

    // @PostMapping("/orgs")
    // public Organization addOrganization(@RequestBody Organization organization) {
    // var m = Set.copyOf(organization.getMembers());
    // organization.getMembers().clear();
    // for (Member member : m) {
    // if (member.getId() != null)
    // organization.getMembers()
    // .add(
    // memberRepository.findById(member.getId())
    // .orElse(member));
    // else
    // organization.getMembers()
    // .add(member);
    // }

    // return orgrepo.save(organization);

    // // return orgrepo.findByName("Gulfuddens AIK");
    // // return orgrepo.findOrganizationByMembersName("Martin");
    // }

}