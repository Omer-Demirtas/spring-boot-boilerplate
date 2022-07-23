package com.boilerplate.service.impl;

import com.boilerplate.domain.Person;
import com.boilerplate.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService
{
    private static final List<Person> persons = new ArrayList<>() {{
        add(new Person(1L, "Jon", "Smith", 51));
        add(new Person(2L, "Ömer", "Demirtaş", 41));
        add(new Person(3L, "Emir", "Demirtaş", 31));
        add(new Person(4L, "Halil", "Demirtaş", 21));
    }};

    @Override
    public Person getPersonById(Long id) throws Exception {
        Optional<Person> person = persons.stream().filter(p -> p.getId().equals(id)).findAny();

        if (person.isEmpty())
        {
            throw new Exception("Not Found");
        }
        return person.get();

    }
}
