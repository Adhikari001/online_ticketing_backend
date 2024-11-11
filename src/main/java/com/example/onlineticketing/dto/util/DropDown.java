package com.example.onlineticketing.dto.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DropDown {
    private Long id;
    private String value;

    public DropDown(Long id , String firstName, String lastName) {
        this.id = id;
        this.value = (firstName!=null? firstName: "" )+ " " + (lastName!=null? lastName: "");
    }

    public static void main(String[] args) {
        String firstName = null;
        String lastName = null;
        System.out.println(firstName + " " + lastName);
    }
}
