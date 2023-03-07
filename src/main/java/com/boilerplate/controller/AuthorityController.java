package com.boilerplate.controller;

import com.boilerplate.domain.User;
import com.boilerplate.dto.UserRoleRequest;
import com.boilerplate.repository.AuthorityRepository;
import com.boilerplate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authority")
public class AuthorityController {
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @PostMapping("/set")
    public Boolean setAuthority(@RequestBody UserRoleRequest userRoleRequest) {
        User user = userRepository.findById(userRoleRequest.getUserId()).get();

        return true;
    }
}
