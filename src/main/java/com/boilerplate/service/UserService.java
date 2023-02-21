package com.boilerplate.service;

import com.boilerplate.domain.User;

import java.util.List;

public interface UserService
{
    User getPersonById(Long id) throws Exception;

    List<User> getAll();

    User create(User user);

    User getOneUserByUserName(String userName);
}
