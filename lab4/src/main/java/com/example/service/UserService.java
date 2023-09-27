package com.example.service;

import com.example.entity.User;
import com.example.entity.request.UpsertUserRequest;
import org.springframework.data.domain.Page;

public interface UserService {
    long create(User user);

    User findById(long userId);

    void deleteById(long userId);

    void updateById(long userId, UpsertUserRequest request);

    Page<User> findAll(int offset, int limit);
}
