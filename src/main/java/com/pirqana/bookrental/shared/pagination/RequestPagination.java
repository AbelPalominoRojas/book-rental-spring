package com.pirqana.bookrental.shared.pagination;

import lombok.Data;

import java.util.Optional;

@Data
public class RequestPagination<T> {
    private int page;

    private int size;

    // private Sort sort;

    private Optional<T> filter;

}
