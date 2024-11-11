package com.example.onlineticketing.dto.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ValueLabelDropdown {
    private String value;
    private String label;

    public ValueLabelDropdown(Long value, String label) {
        this.value = String.valueOf(value);
        this.label = label;
    }

    public ValueLabelDropdown(UUID id , String firstName, String lastName) {
        this.value = String.valueOf(id);
        this.label = (firstName!=null? firstName: "" )+ " " + (lastName!=null? lastName: "");
    }

    public ValueLabelDropdown(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
