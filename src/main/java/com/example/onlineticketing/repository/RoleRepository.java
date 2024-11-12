package com.example.onlineticketing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onlineticketing.entity.person.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select role from Role role where name = :roleName")
    Optional<Role> findByName(String roleName);

}
