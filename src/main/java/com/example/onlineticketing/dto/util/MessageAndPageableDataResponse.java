package com.example.onlineticketing.dto.util;



import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MessageAndPageableDataResponse <T> {
    private String message;
    private PageableData<List<T>> data;
}
