package com.boilerplate.service;

import com.boilerplate.domain.Person;

import java.util.Set;

public interface PersonService
{
    Person getPersonById(Long id) throws Exception;

    Set<Person> getAll();
}
