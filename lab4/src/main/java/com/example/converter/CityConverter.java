package com.example.converter;

import com.example.entity.City;
import com.example.entity.request.CreateCityRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CityConverter {
    City fromCreateCityRequest(CreateCityRequest request);
}
