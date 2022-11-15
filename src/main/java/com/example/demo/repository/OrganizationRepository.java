package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Organization;

import jakarta.transaction.Transactional;

public interface OrganizationRepository extends CrudRepository<Organization, Long>{
    
    // @Query("""
    //         SELECT o FROM Organization o  WHERE o.name = :name
    //         """)
    // List<Organization> findByName(@Param("name") String name);
    
    List<Proj> findAllByName(String name);

    List<Organization> findByName(String name);

    List<Organization> findOrganizationByMembersName(String name);

    @Query("UPDATE Organization SET name = :prefix || name")
    @Modifying
    void addPrefixToName(@Param("prefix") String prefix);

}
