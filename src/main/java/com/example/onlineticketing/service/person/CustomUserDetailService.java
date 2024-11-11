package com.example.onlineticketing.service.person;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.onlineticketing.entity.person.Person;

public class CustomUserDetailService implements UserDetails {
    private final Person person;

    public CustomUserDetailService(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return person.getRole().getGrantedAuthorities().stream()
            .map(authority-> new SimpleGrantedAuthority((authority.getName()))).toList();
    }

    @Override
    public String getPassword() {
        return person.getHashedPassword();
    }

    @Override
    public String getUsername() {
        return person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return person.isActive();
    }

}
