package com.example.onlineticketing.service.person;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.onlineticketing.comms.exceptionhandler.RestException;
import com.example.onlineticketing.entity.person.Person;
import com.example.onlineticketing.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonValidatorImpl implements PersonValidator {
    private final PersonRepository personRepository;

    @Override
    public Person validatePerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new RestException("PV001", "Can not find person with the given id."));
    }

    @Override
    public Person getLoggedInPerson() {
        String userName = getLoggedInUsername();
        return personRepository.findByUsername(userName)
                .orElseThrow(() -> new RestException("PV003", "Can not find logged in user"));
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if (authentication instanceof JwtAuthenticationToken) {
        // return authentication.getName();
        // }
        // throw new RestException("PV002", "Can not find logged in user");
        return authentication.getName();
    }
}
