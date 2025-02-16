package com.boilerplate.service.impl;

import com.boilerplate.annotation.LogThrowClass;
import com.boilerplate.domain.User;
import com.boilerplate.exception.EntityNotValidException;
import com.boilerplate.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Log4j2
@Service
@LogThrowClass
public class UserServiceImpl implements UserService
{
    private static final Set<User> USERS = new HashSet<>() {{
        add(new User(1L, "Jon", "Smith", 51));
        add(new User(2L, "Ömer", "Demirtaş", 41));
        add(new User(3L, "Emir", "Demirtaş", 31));
        add(new User(4L, "Halil", "Demirtaş", 21));
    }};

    @Override
    public User getPersonById(Long id)
    {
        if(id == 2) throw new EntityNotValidException(id.toString());

        Optional<User> person = USERS.stream().filter(p -> p.getId().equals(id)).findAny();

        if (person.isEmpty()) {
            throw new RuntimeException(id.toString());
        }

        return person.get();
    }

    @Override
    public Set<User> getAll()
    {
        return USERS;
    }

    @Override
    public User create(User user)
    {
        if (user.getFirstName() == null) throw new RuntimeException(user.getLastName());

        USERS.add(user);
        user.setId(USERS.stream().toList().get(USERS.size() -1).getId() + 1);
        return user;
    }
}
