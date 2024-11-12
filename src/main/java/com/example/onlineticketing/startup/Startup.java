package com.example.onlineticketing.startup;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.onlineticketing.entity.person.Person;
import com.example.onlineticketing.entity.person.Role;
import com.example.onlineticketing.repository.PersonRepository;
import com.example.onlineticketing.repository.RoleRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Startup {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @PostConstruct
    public void createDefaultUser() {

        String hashedPassword = passwordEncoder.encode("Saurav@123");

        Optional<Role> optionalUserRole = roleRepository.findByName("MANAGER");
        if (optionalUserRole.isPresent()) {
            return;
        }

        Role role = new Role();
        role.setName("MANAGER");
        role = roleRepository.save(role);

        Person person = new Person("Saurav", "Adhikari", "sauravadhikari001@gmail.com", "sauravadhikari001@gmail.com",
                hashedPassword, role);
        personRepository.save(person);
    }

}
