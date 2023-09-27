package com.example.service.impl;

import com.example.entity.Citizenship;
import com.example.entity.City;
import com.example.entity.User;
import com.example.exception.message.CitizenshipExceptionMessage;
import com.example.exception.message.CityExceptionMessage;
import com.example.repository.CitizenshipRepository;
import com.example.repository.CityRepository;
import com.example.service.CitizenshipService;
import com.example.service.CityService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CitizenshipServiceImpl implements CitizenshipService {
    private final CitizenshipRepository repository;
    private final UserService userService;

    @Override
    public long create(Citizenship citizenshipForSave) {
        if(repository.existsByName(citizenshipForSave.getName())) {
            throw new EntityExistsException(CitizenshipExceptionMessage.EXISTS);
        }
        return repository.save(citizenshipForSave).getId();
    }

    @Override
    public Citizenship findById(long citizenshipId) {
        return repository.findById(citizenshipId).orElseThrow(
                () -> new EntityNotFoundException(CitizenshipExceptionMessage.NOT_FOUND));
    }

    @Override
    public void deleteById(long citizenshipId) {
        repository.deleteById(citizenshipId);
    }

    @Override
    @Transactional
    public void addToUser(long citizenshipId, long userId) {
        Citizenship citizenship = this.findById(citizenshipId);
        User user = userService.findById(userId);
        user.getCitizenship().add(citizenship);
    }

    @Override
    public Page<Citizenship> findAll(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }
}
