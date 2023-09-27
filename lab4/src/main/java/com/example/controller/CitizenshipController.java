package com.example.controller;

import com.example.converter.CitizenshipConverter;
import com.example.entity.Citizenship;
import com.example.entity.City;
import com.example.entity.request.CreateCitizenshipRequest;
import com.example.service.CitizenshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/citizenship")
public class CitizenshipController {
    private final CitizenshipService citizenshipService;
    private final CitizenshipConverter citizenshipConverter;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CreateCitizenshipRequest request) {
        Citizenship citizenshipForSave = citizenshipConverter.fromCreateCitizenshipRequest(request);
        long createdSolutionId = citizenshipService.create(citizenshipForSave);
        return new ResponseEntity<>(createdSolutionId, CREATED);
    }

    @GetMapping("/{citizenshipId}")
    public ResponseEntity<Citizenship> findById(@PathVariable long citizenshipId) {
        Citizenship foundCitizenship = citizenshipService.findById(citizenshipId);
        return new ResponseEntity<>(foundCitizenship, FOUND);
    }

    @DeleteMapping("/{citizenshipId}")
    public void deleteById(@PathVariable long citizenshipId) {
        citizenshipService.deleteById(citizenshipId);
    }

    @PatchMapping("/{citizenshipId}/users/{userId}")
    public void addCityToUser(@PathVariable long citizenshipId, @PathVariable long userId) {
        citizenshipService.addToUser(citizenshipId, userId);
    }

    @GetMapping
    public Page<Citizenship> findAll(
            @RequestParam("offset") int offset,
            @RequestParam("limit") int limit
    ) {
        return citizenshipService.findAll(offset, limit);
    }
}
