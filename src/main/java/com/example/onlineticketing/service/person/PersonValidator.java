package com.example.onlineticketing.service.person;

import com.example.onlineticketing.entity.person.Person;

public interface PersonValidator {
    Person validatePerson(Long id);

    Person getLoggedInPerson();
}
