package com.boilerplate.service;

import com.boilerplate.domain.Person;

public interface PersonService
{
    Person getPersonById(Long id) throws Exception;

}
