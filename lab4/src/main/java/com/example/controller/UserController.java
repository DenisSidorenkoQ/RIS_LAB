package com.example.controller;

import com.example.converter.UserConverter;
import com.example.entity.Citizenship;
import com.example.entity.User;
import com.example.entity.request.UpsertUserRequest;
import com.example.entity.response.UserResponse;
import com.example.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid UpsertUserRequest request) {
        User userForSave = userConverter.fromCreateUserRequest(request);
        long createdSolutionId = userService.create(userForSave);
        return new ResponseEntity<>(createdSolutionId, CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable long userId) {
        User foundUser = userService.findById(userId);
        UserResponse userResponse = userConverter.toUserResponse(foundUser);
        return new ResponseEntity<>(userResponse, FOUND);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable long userId) {
        userService.deleteById(userId);
    }

    @PutMapping("/{userId}")
    public void updateById(@PathVariable long userId, @RequestBody @Valid UpsertUserRequest request) {
        userService.updateById(userId, request);
    }

    @GetMapping
    public Page<User> findAll(
            @RequestParam("offset") int offset,
            @RequestParam("limit") int limit
    ) {
        return userService.findAll(offset, limit);
    }
}
