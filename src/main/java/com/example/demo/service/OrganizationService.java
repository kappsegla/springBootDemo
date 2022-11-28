package com.example.demo.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAll() {
        return StreamSupport
                .stream(organizationRepository.findAll().spliterator(), false)
                .toList();
    }

}
