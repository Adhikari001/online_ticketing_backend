package com.example.onlineticketing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.example.onlineticketing.entity.person.Person;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class EntityBaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "added_date")
    protected LocalDateTime addedDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    protected Person addedPerson;

    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    protected Person updatedPerson;

    @Column(name = "is_disabled")
    protected boolean isDisabled;

    public EntityBaseClass(Person createdBy) {
        this.addedDate = LocalDateTime.now();
        this.addedPerson = createdBy;
        this.isDisabled = false;
        this.updatedDate = this.addedDate;
        this.updatedPerson  = this.addedPerson;
    }

    public void update(Person updatedBy) {
        this.updatedDate = LocalDateTime.now();
        this.updatedPerson = updatedBy;
    }
}
