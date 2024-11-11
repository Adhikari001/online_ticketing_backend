package com.example.onlineticketing.dto.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageableData<T> {
    private T data;
    private int totalPage;
    private long totalData;
    private int pageNumber;

    public PageableData(T data, int totalPage, long totalData){
        this.data = data;
        this.totalPage = totalPage;
        this.totalData = totalData;
    }

    public PageableData(T data, int totalPage, long totalData, int pageNumber) {
        this.data = data;
        this.totalPage = totalPage;
        this.totalData = totalData;
        this.pageNumber = pageNumber;
    }
}