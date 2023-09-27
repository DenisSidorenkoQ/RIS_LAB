package com.example.converter;

import com.example.entity.User;
import com.example.entity.request.UpsertUserRequest;
import com.example.entity.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {
    User fromCreateUserRequest(UpsertUserRequest request);
    User fromUpdateUserRequest(Long userId, UpsertUserRequest request);
    UserResponse toUserResponse(User user);
}
