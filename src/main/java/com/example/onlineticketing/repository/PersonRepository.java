package com.example.onlineticketing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.entity.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    Optional<Person> findByUsername(String lowerCase);

    @Query(value = "SELECT new com.example.onlineticketing.dto.person.UserInformation(" +
            "   p.id, p.firstName, p.lastName, p.phoneNumber, p.email, p.gender, p.role, p.isActive " +
            " ) " +
            " FROM Person p WHERE p.isActive = true and p.isDeleted = false")
    List<UserInformation> getAllUsers();

    
}
