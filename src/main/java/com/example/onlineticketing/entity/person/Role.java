package com.example.onlineticketing.entity.person;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import com.example.onlineticketing.entity.EntityBaseClass;


@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends EntityBaseClass {

    @Column(name = "name")
    private String name;

    @Column(name="isDeleted")
    private boolean isDeleted;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<GrantedAuthority> grantedAuthorities;

    public Role() {
    }

    public Role(String name, Set<GrantedAuthority> grantedAuthorities) {
        this.name = name;
        this.grantedAuthorities = grantedAuthorities;
    }
}
