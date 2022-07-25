package com.boilerplate.service.impl;

import com.boilerplate.domain.Person;
import com.boilerplate.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService
{
    private static final Set<Person> persons = new HashSet<>() {{
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

    @Override
    public Set<Person> getAll()
    {
        return persons;
    }

    @Override
    public Person create(Person person)
    {
        persons.add(person);
        person.setId(persons.stream().toList().get(persons.size() -1).getId() + 1);
        return person;
    }
}
