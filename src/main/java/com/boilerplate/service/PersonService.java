package com.boilerplate.service;

import com.boilerplate.domain.Person;
import org.springframework.stereotype.Service;

public interface PersonService
{
    Person getPersonById(Long id) throws Exception;

}
