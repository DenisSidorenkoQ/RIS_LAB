package com.example.service.impl;

import com.example.entity.City;
import com.example.entity.User;
import com.example.exception.message.CityExceptionMessage;
import com.example.repository.CityRepository;
import com.example.service.CityService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;
    private final UserService userService;

    @Override
    public long create(City cityForSave) {
        if(repository.existsByName(cityForSave.getName())) {
            throw new EntityExistsException(CityExceptionMessage.EXISTS);
        }
        return repository.save(cityForSave).getId();
    }

    @Override
    public City findById(long cityId) {
        return repository.findById(cityId).orElseThrow(
                () -> new EntityNotFoundException(CityExceptionMessage.NOT_FOUND));
    }

    @Override
    public void deleteById(long cityId) {
        repository.deleteById(cityId);
    }

    @Override
    @Transactional
    public void addToUser(long cityId, long userId) {
        City city = this.findById(cityId);
        User user = userService.findById(userId);
        user.getCityOfResidence().add(city);
    }

    @Override
    public Page<City> findAll(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }
}
