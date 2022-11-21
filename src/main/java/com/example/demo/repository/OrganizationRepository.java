package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    // @Query("""
    // SELECT o FROM Organization o WHERE o.name = :name
    // """)
    // List<Organization> findByName(@Param("name") String name);

    @Query("""
            SELECT new com.example.demo.repository.Proj(o.name as name) FROM Organization o
            """)
    List<Proj> findBy();

    List<Organization> findByName(String name);

    List<Organization> findOrganizationByMembersName(String name);

    @Query("UPDATE Organization SET name = :prefix || name")
    @Modifying
    void addPrefixToName(@Param("prefix") String prefix);
    
}
