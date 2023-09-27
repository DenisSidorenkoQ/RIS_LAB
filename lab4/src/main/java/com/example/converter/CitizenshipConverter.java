package com.example.converter;

import com.example.entity.Citizenship;
import com.example.entity.City;
import com.example.entity.request.CreateCitizenshipRequest;
import com.example.entity.request.CreateCityRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CitizenshipConverter {
    Citizenship fromCreateCitizenshipRequest(CreateCitizenshipRequest request);
}
