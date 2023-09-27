package com.example.service;

import com.example.entity.Citizenship;
import com.example.entity.City;
import org.springframework.data.domain.Page;

public interface CitizenshipService {
    long create(Citizenship citizenship);

    Citizenship findById(long citizenshipId);

    void deleteById(long citizenshipId);

    void addToUser(long citizenshipId, long userId);

    Page<Citizenship> findAll(int offset, int limit);
}
