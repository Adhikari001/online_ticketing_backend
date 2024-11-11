package com.example.onlineticketing.dto.person;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddDueDateRequest {
    @NotNull(message = "due date can not be empty")
    private String dueDate;
    @NotNull(message = "patient id can not be empty")
    private Long patientId;
}
