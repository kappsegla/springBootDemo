package com.example.demo.repository;

import java.util.List;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Playground;

public interface PlaygroundRepository extends ListCrudRepository<Playground, Long> {

    @Query("""
            SELECT p FROM Playground p WHERE WITHIN(p.coordinate, :geoarea) = true
            """)
    List<Playground> filterOnArea(@Param("geoarea") Geometry<G2D> geoArea);

}
