package com.pirqana.bookrental.shared.pagination;

import lombok.Data;

@Data
public class RequestPagination<T> {
    private int page;

    private int size;

    // private Sort sort;

    private T filter;

}
