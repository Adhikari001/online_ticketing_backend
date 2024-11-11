package com.example.onlineticketing.dto.person;

import com.example.onlineticketing.comms.helper.HelperUtil;
import com.example.onlineticketing.entity.person.Person;
import lombok.Data;

@Data
public class PersonBasicInformation {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;

    public PersonBasicInformation() {
    }

    public PersonBasicInformation(Person person){
        this.id = person.getId();
        this.firstName  = person.getFirstName();
        this.lastName = person.getLastName();
        this.fullName = HelperUtil.getFullName(person.getFirstName(), person.getLastName());
    }
}
