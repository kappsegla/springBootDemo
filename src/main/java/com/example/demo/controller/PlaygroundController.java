package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.geolatte.geom.*;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.builder.DSL.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Playground;
import com.example.demo.repository.PlaygroundRepository;

@RestController
public class PlaygroundController {

    PlaygroundRepository playgroundRepository;

    public PlaygroundController(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    @PostMapping("/playgrounds")
    public ResponseEntity<Playground> insertOne(@RequestBody Playground playground) {
        //playground.setCoordinate(point(WGS84,g(4.33,3.21)));
        var newPlayground = playgroundRepository.save(playground);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPlayground.getId())
                .toUri();

        return ResponseEntity.created(location).body(newPlayground);
    }

    @GetMapping("/playgrounds")
    public List<Playground> allPoints() {
        return playgroundRepository.findAll();
    }

    @GetMapping(path = "/playgrounds", params = "filter")
    public List<Playground> filterPoints(@RequestParam String filter) {
        Geometry<G2D> area = polygon(WGS84, ring(
                g(0.0, 0.0),
                g(10.0, 0.0),
                g(10.0, 10.0),
                g(0.0, 10.0),
                g(0.0, 0.0)));

        return playgroundRepository.filterOnArea(area);
    }

    @GetMapping(path = "/geo")
    public Geometry<G2D> filterPoints() {
        Geometry<G2D> area = polygon(WGS84, ring(
                g(0.0, 0.0),
                g(10.0, 0.0),
                g(10.0, 10.0),
                g(0.0, 10.0),
                g(0.0, 0.0)));

        return area;
    }

}
