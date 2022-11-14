package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{
    
    List<Organization> findByName(String name);

    // List<Organization> findOrganizationByMembersName(String name);

    
}
