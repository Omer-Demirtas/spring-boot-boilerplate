package com.boilerplate.service.impl;

import com.boilerplate.annotation.LogThrowClass;
import com.boilerplate.domain.Person;
import com.boilerplate.exception.EntityNotValidException;
import com.boilerplate.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Log4j2
@Service
@LogThrowClass
public class PersonServiceImpl implements PersonService
{
    private static final Set<Person> persons = new HashSet<>() {{
        add(new Person(1L, "Jon", "Smith", 51));
        add(new Person(2L, "Ömer", "Demirtaş", 41));
        add(new Person(3L, "Emir", "Demirtaş", 31));
        add(new Person(4L, "Halil", "Demirtaş", 21));
    }};

    @Override
    public Person getPersonById(Long id)
    {
        if(id == 2) throw new EntityNotValidException(id.toString());

        Optional<Person> person = persons.stream().filter(p -> p.getId().equals(id)).findAny();

        if (person.isEmpty())
        {
            throw new EntityNotFoundException(id.toString());
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
        if (person.getFirstName() == null) throw new EntityNotFoundException(person.getLastName());

        persons.add(person);
        person.setId(persons.stream().toList().get(persons.size() -1).getId() + 1);
        return person;
    }
}
