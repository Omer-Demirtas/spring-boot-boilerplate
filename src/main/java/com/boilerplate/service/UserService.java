package com.boilerplate.service;

import com.boilerplate.domain.User;

import java.util.Set;

public interface UserService
{
    User getPersonById(Long id) throws Exception;

    Set<User> getAll();

    User create(User user);
}
