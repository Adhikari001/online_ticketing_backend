package com.example.onlineticketing.dto.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageResponseWithId extends MessageResponse{
    private Long id;

    public MessageResponseWithId(String message, Long id) {
        super(message);
        this.id = id;
    }
}
