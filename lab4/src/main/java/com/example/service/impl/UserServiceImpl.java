package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.entity.User;
import com.example.entity.request.UpsertUserRequest;
import com.example.exception.message.UserExceptionMessage;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserConverter userConverter;

    @Override
    public long create(User userForSave) {
        return repository.save(userForSave).getId();
    }

    @Override
    public User findById(long userId) {
        return repository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException(UserExceptionMessage.NOT_FOUND));
    }

    @Override
    public void deleteById(long userId) {
        repository.deleteById(userId);
    }

    @Override
    public void updateById(long userId, UpsertUserRequest request) {
        User userForUpdate = userConverter.fromUpdateUserRequest(userId, request);
        repository.save(userForUpdate);
    }

    @Override
    public Page<User> findAll(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }
}
