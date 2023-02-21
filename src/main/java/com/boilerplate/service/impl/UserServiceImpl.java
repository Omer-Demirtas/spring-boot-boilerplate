package com.boilerplate.service.impl;

import com.boilerplate.annotation.LogThrowClass;
import com.boilerplate.domain.User;
import com.boilerplate.exception.EntityNotValidException;
import com.boilerplate.repository.UserRepository;
import com.boilerplate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Log4j2
@Service
@LogThrowClass
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public User getPersonById(Long id)
    {
        if(id == 2) throw new EntityNotValidException(id.toString());

        Optional<User> person = userRepository.findById(id);

        if (person.isEmpty())
        {
            throw new EntityNotFoundException(id.toString());
        }

        return person.get();
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User create(User user)
    {
        if (user.getFirstName() == null) throw new EntityNotFoundException(user.getLastName());

        return userRepository.save(user);
    }

    @Override
    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
