package com.example.service;

import com.example.entity.City;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    long create(City city);

    City findById(long cityId);

    void deleteById(long cityId);

    void addToUser(long cityId, long userId);

    Page<City> findAll(int offset, int limit);
}
