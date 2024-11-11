package com.example.onlineticketing.entity.person;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import com.example.onlineticketing.constant.enums.GrantedAuthoritiesEnum;

@Entity
@Getter
@Setter
public class GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public GrantedAuthority(){

    }
    public GrantedAuthority(GrantedAuthoritiesEnum grantedAuthoritiesEnum) {
        this.name = grantedAuthoritiesEnum.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantedAuthority that = (GrantedAuthority) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}