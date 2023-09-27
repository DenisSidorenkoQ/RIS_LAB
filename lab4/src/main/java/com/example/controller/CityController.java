package com.example.controller;

import com.example.converter.CityConverter;
import com.example.entity.City;
import com.example.entity.request.CreateCityRequest;
import com.example.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;
    private final CityConverter cityConverter;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CreateCityRequest request) {
        City cityForSave = cityConverter.fromCreateCityRequest(request);
        long createdSolutionId = cityService.create(cityForSave);
        return new ResponseEntity<>(createdSolutionId, CREATED);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> findById(@PathVariable long cityId) {
        City foundCity = cityService.findById(cityId);
        return new ResponseEntity<>(foundCity, FOUND);
    }

    @DeleteMapping("/{cityId}")
    public void deleteById(@PathVariable long cityId) {
        cityService.deleteById(cityId);
    }

    @PatchMapping("/{cityId}/users/{userId}")
    public void addCityToUser(@PathVariable long cityId, @PathVariable long userId) {
        cityService.addToUser(cityId, userId);
    }

    @GetMapping
    public Page<City> findAll(
            @RequestParam("offset") int offset,
            @RequestParam("limit") int limit
    ) {
        return cityService.findAll(offset, limit);
    }
}
