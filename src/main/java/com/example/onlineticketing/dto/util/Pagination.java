package com.example.onlineticketing.dto.util;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private int page =1;
    private int pageSize =10;
    private String sort ="descending";
    private String sortParameter = "id";
    private String search;
    private String status = "all";

    public Pagination(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
}
