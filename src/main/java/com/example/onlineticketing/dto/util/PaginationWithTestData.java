package com.example.onlineticketing.dto.util;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaginationWithTestData extends Pagination {
    @NotNull(message = "from is required")
    private String from;
    @NotNull(message = "to is required")
    private String to;
    private String search;
    @NotNull(message = "filter is required")
    String filterBy;
    private String testData;
}
